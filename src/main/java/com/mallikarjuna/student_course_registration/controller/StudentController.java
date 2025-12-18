//package com.mallikarjuna.student_course_registration.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class StudentController {
//
//    @GetMapping("/health")
//    public String healthCheck() {
//        return "Student Course Registration API is running";
//    }
//}


package com.mallikarjuna.student_course_registration.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mallikarjuna.student_course_registration.entity.Student;
import com.mallikarjuna.student_course_registration.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;


@CrossOrigin(
  origins = {
    "http://localhost:5173",
    "https://student-course-frontend-h75t.onrender.com/"
  }
)
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // POST /students -> add student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }


    // GET /students -> get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // ✅ DELETE API
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (RuntimeException e) {
            if ("STUDENT_NOT_FOUND".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student not found");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
