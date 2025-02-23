package com.example.Haolin_COMP303_Assignment3.controller;

import com.example.Haolin_COMP303_Assignment3.model.Student;
import com.example.Haolin_COMP303_Assignment3.model.Program;
import com.example.Haolin_COMP303_Assignment3.repository.StudentRepository;
import com.example.Haolin_COMP303_Assignment3.repository.ProgramRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students/login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("student", new Student());
        return "login";
    }

    @PostMapping("/login")
    public String loginStudent(@ModelAttribute Student student, Model model, HttpSession session) {
        Student authenticatedStudent = studentRepository.findByUsernameAndPassword(student.getUsername(), student.getPassword());
        if (authenticatedStudent != null) {
            session.setAttribute("loggedInUser", authenticatedStudent);
            return "redirect:/students/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

    @GetMapping("/programs")
    public String listPrograms(Model model) {
        model.addAttribute("programs", programRepository.findAll());
        return "programs";
    }

    @PostMapping("/enroll")
    public String enrollInProgram(@RequestParam("programCode") String programCode, Model model) {
        Program program = programRepository.findById(programCode).orElse(null);
        if (program != null) {
            // 创建报名信息并保存到数据库
        }
        return "redirect:/students/payment";
    }

    @GetMapping("/payment")
    public String showPaymentPage() {
        return "payment";
    }

    @PostMapping("/payment")
    public String processPayment() {
        return "redirect:/students/payment-confirmation";
    }

    @GetMapping("/payment-confirmation")
    public String showPaymentConfirmation() {
        return "payment-confirmation";
    }

    @GetMapping("/profile")
    public String showProfilePage(HttpSession session, Model model) {
        Student loggedInStudent = (Student) session.getAttribute("loggedInUser");
        if (loggedInStudent == null) {
            return "redirect:/students/login";
        }
        model.addAttribute("student", loggedInStudent);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute Student student, HttpSession session) {
        Student loggedInStudent = (Student) session.getAttribute("loggedInUser");
        if (loggedInStudent == null) {
            return "redirect:/students/login";
        }

        // 更新信息
        loggedInStudent.setFirstname(student.getFirstname());
        loggedInStudent.setLastname(student.getLastname());
        loggedInStudent.setEmail(student.getEmail());
        loggedInStudent.setAddress(student.getAddress());
        loggedInStudent.setCity(student.getCity());
        loggedInStudent.setPostalCode(student.getPostalCode());

        studentRepository.save(loggedInStudent);
        session.setAttribute("loggedInUser", loggedInStudent); // 更新 session

        return "redirect:/students/profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/students/login";
    }
}
