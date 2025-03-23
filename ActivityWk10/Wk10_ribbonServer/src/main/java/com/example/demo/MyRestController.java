package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyRestController {
    @Autowired
    private Environment environment;
    @GetMapping("/server")
    public String server() {
        return "Hello from Ribbon Server! Port: " + environment.getProperty("server.port");
    }
}
