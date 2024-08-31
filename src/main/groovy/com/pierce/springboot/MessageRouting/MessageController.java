package com.pierce.springboot.MessageRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageRouterFactory messageRouterFactory;

    @Autowired
    public MessageController(MessageRouterFactory messageRouterFactory) {
        this.messageRouterFactory = messageRouterFactory;
    }

    @PostMapping("/route")
    public String routeMessage(@RequestBody MessageRequest messageRequest) {
        MessageRouter router = messageRouterFactory.getRouter(messageRequest.getMessage());
        return router.route(messageRequest.getMessage());
    }
}
