package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    //    LOGIN
    @GetMapping({"/login", "/"})
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public String successLogin(Authentication authResult, Model model) {
        String role = authResult.getAuthorities().toString();
        model.addAttribute("role", role);

        if (role.contains("ADMIN")) {
            return "redirect:/admin_page";
        } else if (role.contains("USER")) {
            return "redirect:/home_page";
        }
        //fall back
        return "error/404";
    }

    @GetMapping("/listing")
    public String listing(Model model) {
        model.addAttribute("allListings", getAllListing());
        return "listing";
    }

    @GetMapping("/house/{id}")
    public String house(@PathVariable("id") long id, Model model, HttpServletRequest request) {
        Listing listing = listingService.findByListingId(id);
        model.addAttribute("listing", listing);

      
        User host = listing.getOwner();
        model.addAttribute("host", host);

        model.addAttribute("request", request); // Add the request object to the model

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

    @GetMapping("/account")
    public String account(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        List<Listing> listings = listingService.findByOwner(user);

        model.addAttribute("user", user);
        model.addAttribute("listings", listings);

        return "account";
    }

    @GetMapping("/favourites")
    public String favourites() {
        return "favourites";
    }

    @GetMapping("/help")
    public String help() {
        return "help";
    }

    @GetMapping("/message")
    public String message() {
        return "message";
    }


}
