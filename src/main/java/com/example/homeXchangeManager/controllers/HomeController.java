package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.RegisterDto;
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
    public String register(Model model) {
        model.addAttribute("user", new RegisterDto());
        return "registration";
    }

    @GetMapping("/")
    public String home() {
        return "login";
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
