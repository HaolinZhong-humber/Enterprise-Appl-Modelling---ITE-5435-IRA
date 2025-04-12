package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping("/reservation")
    public Reservation createReservation(@RequestBody Reservation r) {
        return reservationRepository.save(r);
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservation(@PathVariable String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @PutMapping("/reservation/{id}")
    public Reservation updateReservation(@PathVariable String id,
                                         @RequestBody Reservation r) {
        r.setId(id);
        return reservationRepository.save(r);
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationRepository.deleteById(id);
    }
}
