package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class SearchController {

    private UserService userService;

    private ListingService listingService;

    @Autowired
    public SearchController(UserService userService, ListingService listingService) {
        this.userService = userService;
        this.listingService = listingService;
    }

    @RequestMapping("/listings/city/availability")
    public String listingsByCityAndAvailability(Model model, @RequestParam String city, @RequestParam Date start, @RequestParam Date end) {
        List<Listing> listingsSearch = listingService.findAllByCityAndAvailabilityStartBetween(city, start, end);
        model.addAttribute("listingsSearch", listingsSearch);
        return "home_page";
    }

    @RequestMapping("/listings/city")
    public String listingsByCity(Model model, @RequestParam String city) {
        List<Listing> listings = listingService.findByCity(city);
        model.addAttribute("listingsSearch", listings);

        return "redirect:/listing";
    }

}
