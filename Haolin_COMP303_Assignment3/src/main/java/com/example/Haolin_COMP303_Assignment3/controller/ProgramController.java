package com.example.Haolin_COMP303_Assignment3.controller;

import com.example.Haolin_COMP303_Assignment3.model.Program;
import com.example.Haolin_COMP303_Assignment3.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping("/programs")
    public String listPrograms(Model model) {
        model.addAttribute("programs", programRepository.findAll());
        return "programs";
    }
}
