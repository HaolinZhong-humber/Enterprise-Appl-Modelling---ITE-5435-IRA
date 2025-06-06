package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class MyClientSideController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/client-call")
    public String clientCall() {
        return restTemplate.getForObject("http://Wk10_ribbonServer/server", String.class);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
