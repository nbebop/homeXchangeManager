package com.example.homeXchangeManager.dto;

import com.example.homeXchangeManager.models.User;
import lombok.Data;

@Data
public class MessageDto {
    private int messageId;
    private String sender;
    private String receiver;
    private String content;
}
