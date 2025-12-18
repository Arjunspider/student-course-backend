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

import jakarta.validation.Valid;


@CrossOrigin(
  origins = {
    "http://localhost:5173",
    "https://student-course-frontend.onrender.com"
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
}
