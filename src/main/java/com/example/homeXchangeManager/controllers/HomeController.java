package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private ListingService listingService;


    @Autowired
    public HomeController(UserService userService, ListingService listingService) {
        this.userService = userService;
        this.listingService = listingService;
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
    public String home_page(Model model) {
        model.addAttribute("listings", getAllListing());

        return "home_page";
    }

    private List<Listing> getAllListing() {
        return listingService.findAll();
    }

}
