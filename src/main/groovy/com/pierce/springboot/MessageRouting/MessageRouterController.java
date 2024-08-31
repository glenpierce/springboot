package com.pierce.springboot.MessageRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageRouterController {

    private final ApplicationContext applicationContext;

    @Autowired
    public MessageRouterController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostMapping("/route")
    public String routeMessage(@RequestBody MessageRequest messageRequest) {
        MessageType messageType = MessageType.fromMessage(messageRequest.getMessage());
        MessageRouter router = applicationContext.getBean(messageType.getRouterClass());
        return router.route(messageRequest.getMessage());
    }
}