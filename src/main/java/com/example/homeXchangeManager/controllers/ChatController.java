package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.MessageDto;
import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.UserRepository;
import com.example.homeXchangeManager.service.ChatService;
import com.example.homeXchangeManager.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final ChatService chatService;
    private  UserServiceImpl userService;

    public ChatController(ChatService chatService, UserServiceImpl userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @PostMapping("/chat/send")
    public String sendMessage(@ModelAttribute("message") MessageDto messageDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            logger.debug(errorMessages);

            return "message";
        }

        // retrieve logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userService.findByUsername(auth.getName());

        // Fetch sender and receiver from the database based on the provided IDs
        //Optional<User> senderOptional = userRepository.findById(sender.getId());
        User receiver = userService.findByUsername(messageDto.getReceiver());
        //Optional<User> receiverOptional = userRepository.findById(receiver.getId());


        // sender = senderOptional.get();
        // User receiver = receiverOptional.get();

        chatService.saveMessage(sender, receiver, messageDto.getContent());
        return "redirect:/message";
    }

    @GetMapping("/message")
    public List<Message> getChatMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        // Fetch sender and receiver from the database based on the provided IDs
        User sender = userService.findById(senderId);
        User receiver = userService.findById(receiverId);

        if (sender == null || receiver == null) {
            throw new IllegalArgumentException("Invalid sender or receiver ID.");
        }

        return chatService.getChatMessages(sender, receiver);
    }
}
