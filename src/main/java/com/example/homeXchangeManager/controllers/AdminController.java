package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(ListingController.class);
    private UserService userService;
    private ListingService listingService;

    public AdminController(UserService userService, ListingService listingService) {
        this.userService = userService;
        this.listingService = listingService;
    }


    @GetMapping("/admin_page")
    public String adminPage(Model model) {
        model.addAttribute("listings", getAllListing());
        model.addAttribute("users", getAllUsers());
        return "admin_page";
    }

    @PostMapping("/admin/delete/listing/{id}")
    public String deleteListing(@PathVariable("id") long listingId) {
        Listing listing = listingService.findByListingId(listingId);
        if (listing != null) {
            listingService.delete(listingId);
            logger.debug(String.format("Listing with id: %s has been successfully deleted.", listing.getListingId()));
            return "redirect:/admin_page";
        } else {
            // add error pages
            return "error/404";
        }
    }

    @PostMapping("/admin/delete/user/{id}")
    public String deleteUser(@PathVariable("id") long userId) {
        User user = userService.findById(userId);
        if (user != null) {
            userService.delete(userId);
            logger.debug(String.format("user with id: %s has been successfully deleted.", user.getId()));
            return "redirect:/admin_page";
        } else {
            return "error/404";
        }
    }

    private List<User> getAllUsers() {
        return userService.findAll();

    }

    private List<Listing> getAllListing() {
        return listingService.findAll();
    }
}
