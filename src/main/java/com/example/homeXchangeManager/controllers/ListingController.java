package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class ListingController {
    private static final Logger logger = LoggerFactory.getLogger(ListingController.class);
    private ListingServiceImpl listingService;
    private ListingRepository listingRepository;
    private UserServiceImpl userService;
    private ServiceServiceImpl serviceService;
    private ConstraintServiceImpl constraintService;
    private ImageStorageServiceImpl imageService;
    private ListingRatingServiceImpl ratingService;

    @Autowired
    public ListingController(ListingServiceImpl listingService, UserServiceImpl userService,
                             ServiceServiceImpl serviceService, ConstraintServiceImpl constraintService,
                             ListingRepository listingRepository, ImageStorageServiceImpl imageService,
                             ListingRatingServiceImpl ratingService) {
        this.listingService = listingService;
        this.userService = userService;
        this.serviceService = serviceService;
        this.constraintService = constraintService;
        this.listingRepository = listingRepository;
        this.imageService = imageService;
        this.ratingService = ratingService;
    }

    @ModelAttribute("listing")
    public ListingDto listingDto() {
        return new ListingDto();
    }

    @GetMapping("/new_listing")
    public String newListing(Model model) {
        model.addAttribute("constraints", constraintService.findAll());
        model.addAttribute("services", serviceService.findAll());
        return "new_listing";
    }


    /**
     * Code to display images in frontend
     */
    @PostMapping("/new_listing")
    public String createListing(@Valid @ModelAttribute("listing") ListingDto listingDto, @RequestParam("images") MultipartFile[] images, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            logger.debug("Binding error messages: " + errorMessages);

            return "new_listing";
        }

        // retrieve logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userService.findByUsername(auth.getName());
        listingDto.setOwner(owner);
        listingService.save(listingDto, images);

        return "redirect:/listing";
    }

    @PostMapping("/listing/delete/{id}")
    public String deleteListing(@PathVariable("id") long listingId) {
        Listing listing = listingService.findByListingId(listingId);
        if (listing != null) {
            listingService.delete(listingId);
            logger.debug(String.format("Listing with id: %s has been successfully deleted.", listing.getListingId()));
            return "redirect:/home_page";
        } else {
            // add error pages
            return "error/404";
        }
    }

    @PostMapping("/listing/edit/{id}")
    public String editListing(@PathVariable("id") long listingId, @Valid @ModelAttribute("listing") ListingDto listingDto, @RequestParam("images") MultipartFile[] images, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_listing";
        }

        Listing listing = listingService.findByListingId(listingId);
        if (listing != null) {
            listingService.edit(listingId, listingDto, images);
            return "redirect:/home_page";
        } else {
            // Listing not found, handle the error appropriately
            return "error/404";
        }
    }

}
