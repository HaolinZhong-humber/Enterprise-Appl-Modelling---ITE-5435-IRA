package com.example.Haolin_COMP303_Assignment3.repository;

import com.example.Haolin_COMP303_Assignment3.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
