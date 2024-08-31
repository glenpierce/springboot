package com.pierce.springboot.MessageRouting;

public enum MessageType {
    WELCOME("welcome", WelcomeMessageRouter.class),
    GOODBYE("goodbye", GoodbyeMessageRouter.class);

    private final String message;
    private final Class<? extends MessageRouter> routerClass;

    MessageType(String message, Class<? extends MessageRouter> routerClass) {
        this.message = message;
        this.routerClass = routerClass;
    }

    public String getMessage() {
        return message;
    }

    public Class<? extends MessageRouter> getRouterClass() {
        return routerClass;
    }

    public static MessageType fromMessage(String message) {
        for (MessageType type : values()) {
            if (type.getMessage().equalsIgnoreCase(message)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown message type: " + message);
    }
}