package com.example.homeXchangeManager.services;

import com.example.homeXchangeManager.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import com.example.homeXchangeManager.models.User;

public interface UserService  extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    List<User> getAll();
}
