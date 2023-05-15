package com.example.homeXchangeManager.dto;

import com.example.homeXchangeManager.models.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;
    private String phoneNumber;
    private String description;
    private Address address;
}
