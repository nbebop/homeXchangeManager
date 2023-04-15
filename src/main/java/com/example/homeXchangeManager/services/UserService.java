package com.example.homeXchangeManager.services;

import com.example.homeXchangeManager.dto.UserRegistrationDto;
import com.example.homeXchangeManager.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    List<User> getAll();
}
