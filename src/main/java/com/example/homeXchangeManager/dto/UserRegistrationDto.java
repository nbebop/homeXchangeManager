package com.example.homeXchangeManager.dto;

import java.text.SimpleDateFormat;

public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
    private String lastName;
    private SimpleDateFormat birthDate;
    private String phoneNumber;
    private String userDescription;

    public UserRegistrationDto() {
    }


    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SimpleDateFormat getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(SimpleDateFormat birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
