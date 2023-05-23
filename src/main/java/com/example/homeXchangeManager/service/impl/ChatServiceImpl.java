package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.MessageRepository;
import com.example.homeXchangeManager.service.ChatService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final MessageRepository messageRepository;

    public ChatServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveMessage(User sender, User receiver, String content) {
        // get time
        LocalDateTime currentDateTime = LocalDateTime.now(); // Get the current date and time
        // Convert LocalDateTime to Date
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = currentDateTime.atZone(zoneId).toInstant();
        Date currentDate = Date.from(instant);
        Message message = new Message(sender, receiver, content, currentDate);
        messageRepository.save(message);
    }

    @Override
    public List<Message> getChatMessages(User sender, User receiver) {
        return messageRepository.findBySenderAndReceiverOrReceiverAndSenderOrderByTimestamp(sender, receiver, sender, receiver);
    }
}
