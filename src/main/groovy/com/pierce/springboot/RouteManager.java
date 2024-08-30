package com.pierce.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
class RouteManager {

    @GetMapping("/")
    String welcome() {
        return "Welcome to Spring Boot!";
    }
}