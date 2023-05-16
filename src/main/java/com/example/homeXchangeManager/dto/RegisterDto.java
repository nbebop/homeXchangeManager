package com.example.homeXchangeManager.dto;

import com.example.homeXchangeManager.constraints.BirthDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @BirthDate(message = "You must be older than 18 years old to sign up!")
    private Date birthdate;
    private String phoneNumber;
    private String description;
    private String addressLine;
    private String city;
    private String postalCode;
    private String country;
    private String premise;
}
