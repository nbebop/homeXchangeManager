package com.example.homeXchangeManager.dto;

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
    private String addressLine;
    private String city;
    private String postalCode;
    private String country;
    private String premise;
}
