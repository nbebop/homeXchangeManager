package com.example.homeXchangeManager.dto;

import com.example.homeXchangeManager.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class RegisterDto {
    @UsernameConstraint
    private String username;
    @PasswordConstraint
    private String password;
    @EmailConstraint
    private String email;
    @NameConstraint //Name constraint for fields that allow only letters (not numbers)
    private String firstname;
    @NameConstraint
    private String lastname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @BirthDate(message = "You must be older than 18 years old to sign up!")
    private Date birthdate;
    @PhoneNumberConstraint
    private String phoneNumber;
    private String description;
    private String addressLine;
    @NameConstraint
    private String city;
    @PostalCodeConstraint
    private String postalCode;
    @NameConstraint
    private String country;
    @NameConstraint
    private String premise;
}
