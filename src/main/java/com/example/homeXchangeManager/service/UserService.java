package com.example.homeXchangeManager.service;


import com.example.homeXchangeManager.models.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(long id);

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(long id);

    List<User> findAll();
}
