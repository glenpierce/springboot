package com.pierce.springboot.MessageRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MessageRouterFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public MessageRouterFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public MessageRouter getRouter(String message) {
        MessageType messageType = MessageType.fromMessage(message);
        return applicationContext.getBean(messageType.getRouterClass());
    }
}