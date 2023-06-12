package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.User;

import java.util.List;

public interface ChatService {
    void sendMessage(User sender, User receiver, String content);
    List<Message> getChatMessages(User sender, User receiver);
}
