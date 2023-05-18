package com.example.homeXchangeManager.service;


import com.example.homeXchangeManager.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(long id);
}
