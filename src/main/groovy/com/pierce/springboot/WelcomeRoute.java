package com.pierce.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
class WelcomeRoute {

    @GetMapping("/")
    String welcome() {
        return "Welcome to Spring Boot!";
    }
}