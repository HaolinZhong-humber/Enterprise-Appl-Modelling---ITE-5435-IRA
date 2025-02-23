package com.assign4.controller;

import com.assign4.model.WorkshopRegistration;
import com.assign4.repository.WorkshopRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class WorkshopRegistrationController {

    @Autowired
    private WorkshopRegistrationRepo repository;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("registration", new WorkshopRegistration());
        return "register";
    }

    @PostMapping("/submit")
    public String processRegistration(@Valid @ModelAttribute("registration") WorkshopRegistration registration, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        repository.save(registration);
        return "redirect:/register/list";
    }

    @GetMapping("/list")
    public String showRegistrations(Model model) {
        model.addAttribute("registrations", repository.findAll());
        return "list";
    }
}
