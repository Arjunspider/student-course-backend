package com.mallikarjuna.student_course_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mallikarjuna.student_course_registration.entity.Student;



public interface StudentRepository extends JpaRepository<Student, Long> {
	boolean existsByEmail(String email);
}
