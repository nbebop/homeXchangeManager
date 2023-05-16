package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.UserRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private UserRepository userRepository;

    @MessageMapping("/message/{to}")
    public void sendMessage(@DestinationVariable User receiver, Message message){
        System.out.println("Handling send message: " + message + " to: " + receiver);
        //boolean userExists = userRepository.findByUsername(receiver.getUsername());
        // TODO: figure out what is going on there
    }
}
