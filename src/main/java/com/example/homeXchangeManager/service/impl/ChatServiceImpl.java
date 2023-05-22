package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.MessageRepository;
import com.example.homeXchangeManager.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final MessageRepository messageRepository;

    public ChatServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void sendMessage(User sender, User receiver, String content) {
        Message message = new Message(sender, receiver, content, new Date());
        messageRepository.save(message);
    }

    @Override
    public List<Message> getChatMessages(User sender, User receiver) {
        return messageRepository.findBySenderAndReceiverOrReceiverAndSenderOrderByTimestamp(sender, receiver, sender, receiver);
    }
}
