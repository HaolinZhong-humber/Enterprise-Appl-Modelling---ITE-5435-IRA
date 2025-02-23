package com.example.Haolin_COMP303_Assignment3.repository;

import com.example.Haolin_COMP303_Assignment3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsernameAndPassword(String username, String password);
}
