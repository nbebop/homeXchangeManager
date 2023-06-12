package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.RatingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.service.impl.ListingRatingServiceImpl;
import com.example.homeXchangeManager.service.impl.ListingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RatingController {
    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);
    private ListingRatingServiceImpl ratingService;
    private ListingServiceImpl listingService;

    @Autowired
    public RatingController(ListingRatingServiceImpl ratingService, ListingServiceImpl listingService) {
        this.ratingService = ratingService;
        this.listingService = listingService;
    }

    @ModelAttribute("rating")
    public RatingDto ratingDto() {
        return new RatingDto();
    }

    @GetMapping("/listing/rate/{id}")
    public String rateListing(@PathVariable("id") long listingId, Model model, HttpServletRequest request){
        Listing listing = listingService.findByListingId(listingId);
        User listingOwner = listing.getOwner();
        model.addAttribute("listing", listing);
        model.addAttribute("owner", listingOwner);
        model.addAttribute("request", request);
        return "rate";
    }

    @PostMapping("/listing/rate")
    public String rateListing( @Valid @ModelAttribute("rating") RatingDto ratingDto) {
        // ratingDto needs reviewerId, listingId (these are passed from us in: @GetMapping("/listing/rate/{id}")
        // score, description (user input)
        // make sure the names are right. it is tested and works
        ratingService.save(ratingDto);
        return "redirect:/home_page"; // or change page
    }

}
