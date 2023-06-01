package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    private UserService userService;

    private ListingService listingService;

    @Autowired
    public SearchController(UserService userService, ListingService listingService) {
        this.userService = userService;
        this.listingService = listingService;
    }

    @GetMapping("/listings/search/advanced")
    public String listingsByCityAndAvailability(@RequestParam String cityAdvanced, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd, Model model) {
        // keeping it as debug statement
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // logger.debug("end: "+ simpleDateFormat.format(dateEnd));

        List<Listing> listingsSearch = listingService.findAllByCityAndAvailabilityStartBetween(cityAdvanced, dateStart, dateEnd);
        model.addAttribute("listingsAdvancedSearch", listingsSearch);
        model.addAttribute("advancedSearch", true);

        return "/listing";
    }

    @GetMapping("/listings/search/simple")
    public String listingsByCity(@RequestParam String citySimple, Model model) {
        List<Listing> listings = listingService.findByCity(citySimple);

        model.addAttribute("listingsSimpleSearch", listings);
        model.addAttribute("simpleSearch", true);

        return "/listing";
    }

}
