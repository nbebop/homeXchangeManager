package com.example.homeXchangeManager.dto;

public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;

    public UserRegistrationDto() {}


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
}
