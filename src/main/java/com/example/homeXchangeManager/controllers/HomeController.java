package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String register() {
        return "registration";
    }

    @GetMapping("/")
    public String home() {
        return "login";
    }

}
