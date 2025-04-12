package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/")
    public String home() {
        return "reservation";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String customerName,
                         @RequestParam String flightNumber,
                         @RequestParam double amount) {
        Reservation r = new Reservation();
        r.setCustomerName(customerName);
        r.setFlightNumber(flightNumber);
        r.setAmount(amount);
        reservationRepository.save(r);
        return "success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
