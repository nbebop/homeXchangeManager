package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import com.example.homeXchangeManager.service.impl.ListingRatingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private PasswordEncoder passwordEncoder;
    private UserService userService;
    private ListingService listingService;
    private ListingRatingServiceImpl ratingService;


    @Autowired
    public HomeController(UserService userService, ListingService listingService,
                          ListingRatingServiceImpl ratingService) {
        this.userService = userService;
        this.listingService = listingService;
        this.ratingService = ratingService;
    }

    //    LOGIN
    @GetMapping({"/login", "/"})
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public String successLogin(Authentication authResult, Model model, RedirectAttributes redirectAttributes) {
        String role = authResult.getAuthorities().toString();
        model.addAttribute("role", role);
        redirectAttributes.addFlashAttribute("successMessage", "User signed in successfully");

        if (role.contains("ADMIN")) {
            return "redirect:/admin/admin_page";
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
        User host = listing.getOwner();
        double avgListingRating = ratingService.calculateAverageRating(listing);

        model.addAttribute("host", host);
        model.addAttribute("listing", listing);
        model.addAttribute("rating", avgListingRating);
        model.addAttribute("request", request);

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
        Listing listing = listingService.findByOwner(user);

        model.addAttribute("user", user);
        model.addAttribute("listing", listing);

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

    @GetMapping("/forgotten")
    public String forgotten() {
        return "forgotten";
    }

    @GetMapping("/reset")
    public String reset() {
        return "reset";
    }


}
