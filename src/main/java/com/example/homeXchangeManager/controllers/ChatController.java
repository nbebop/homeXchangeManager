package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.UserRepository;
import com.example.homeXchangeManager.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;
    private final UserRepository userRepository;

    public ChatController(ChatService chatService, UserRepository userRepository) {
        this.chatService = chatService;
        this.userRepository = userRepository;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam Long senderId, @RequestParam Long receiverId,
                                              @RequestParam String content) {
        // Fetch sender and receiver from the database based on the provided IDs
        Optional<User> senderOptional = userRepository.findById(senderId);
        Optional<User> receiverOptional = userRepository.findById(receiverId);

        if (senderOptional.isEmpty() || receiverOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid sender or receiver ID.");
        }

        User sender = senderOptional.get();
        User receiver = receiverOptional.get();

        chatService.sendMessage(sender, receiver, content);
        return ResponseEntity.ok("Message sent successfully.");
    }

    @GetMapping("/messages")
    public List<Message> getChatMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        // Fetch sender and receiver from the database based on the provided IDs
        Optional<User> senderOptional = userRepository.findById(senderId);
        Optional<User> receiverOptional = userRepository.findById(receiverId);

        if (senderOptional.isEmpty() || receiverOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid sender or receiver ID.");
        }

        User sender = senderOptional.get();
        User receiver = receiverOptional.get();

        return chatService.getChatMessages(sender, receiver);
    }
}
