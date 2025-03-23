package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class Wk10RibbonEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Wk10RibbonEurekaServerApplication.class, args);
    }
}
