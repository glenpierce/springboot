package com.pierce.springboot.MessageRouting;

import org.springframework.stereotype.Component;

@Component
public class GoodbyeMessageRouter implements MessageRouter {
    @Override
    public String route(String message) {
        return "Goodbye from Spring Boot!";
    }
}
