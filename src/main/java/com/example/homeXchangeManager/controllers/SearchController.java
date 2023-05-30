package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public String listingsByCityAndAvailability(Model model, @RequestParam String cityAdvanced, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        List<Listing> listingsSearch = listingService.findAllByCityAndAvailabilityStartBetween(cityAdvanced, start, end);
        model.addAttribute("listingsAdvancedSearch", listingsSearch);

        return "/listing";
    }

    @RequestMapping("/listings/city")
    public String listingsByCity(Model model, @RequestParam String citySimple) {
        List<Listing> listings = listingService.findByCity(citySimple);
        model.addAttribute("listingsSimpleSearch", listings);

        return "/listing";
    }

}
