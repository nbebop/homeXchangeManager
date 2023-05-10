package com.example.homeXchangeManager.controllers;

import org.springframework.stereotype.Controller;
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
