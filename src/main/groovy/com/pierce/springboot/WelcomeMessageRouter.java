package com.pierce.springboot;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessageRouter implements MessageRouter {
    @Override
    public String route(String message) {
        return "Welcome to Spring Boot!";
    }
}
