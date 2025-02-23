package com.example.Haolin_COMP303_Assignment3.controller;

import com.example.Haolin_COMP303_Assignment3.model.Enrollment;
import com.example.Haolin_COMP303_Assignment3.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @GetMapping("/enrollment")
    public String listEnrollments(Model model) {
        model.addAttribute("enrollments", enrollmentRepository.findAll());
        return "enrollment";
    }
}
