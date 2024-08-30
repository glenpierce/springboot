package com.pierce.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageRouterFactory {

    private final WelcomeMessageRouter welcomeMessageRouter;
    private final GoodbyeMessageRouter goodbyeMessageRouter;

    @Autowired
    public MessageRouterFactory(WelcomeMessageRouter welcomeMessageRouter, GoodbyeMessageRouter goodbyeMessageRouter) {
        this.welcomeMessageRouter = welcomeMessageRouter;
        this.goodbyeMessageRouter = goodbyeMessageRouter;
    }

    public MessageRouter getRouter(String message) {
        if ("welcome".equalsIgnoreCase(message)) {
            return welcomeMessageRouter;
        } else if ("goodbye".equalsIgnoreCase(message)) {
            return goodbyeMessageRouter;
        } else {
            throw new IllegalArgumentException("Unknown message type: " + message);
        }
    }
}
