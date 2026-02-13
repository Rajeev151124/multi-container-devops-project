package com.devops.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/message")
    public String hello() {
        return "Backend is running via Jenkins + Docker + K8s!";
    }
}

