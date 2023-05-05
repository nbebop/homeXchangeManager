package com.example.homeXchangeManager.dto;

import lombok.Data;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String phoneNumber;
    private String description;
    private String address;
}
