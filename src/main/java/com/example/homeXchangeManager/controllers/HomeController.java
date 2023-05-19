package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.repositories.RoleRepository;
import com.example.homeXchangeManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({"/login", "/"})
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public String successLogin(Authentication authResult) {
        String role = authResult.getAuthorities().toString();

        if (role.contains("ADMIN")) {
            return "admin_page";
        } else if (role.contains("USER")) {
            return "home_page";
        }
        //fall back
        return "error/404";
    }

    @GetMapping("/listing")
    public String listing() {
        return "listing";
    }

    @GetMapping("/house")
    public String house() {
        return "house";
    }

    @GetMapping("/home_page")
    public String home_page() {
        return "home_page";
    }

}
