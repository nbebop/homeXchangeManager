package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.repositories.UserRepository;
import com.example.homeXchangeManager.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ListingController {
    private static final Logger logger = LoggerFactory.getLogger(ListingController.class);
    private AuthenticationManager authenticationManager;
    private ListingRepository listingRepository;
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @Autowired
    public ListingController(ListingRepository listingRepository, UserRepository userRepository, UserServiceImpl userService) {
        this.listingRepository = listingRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @ModelAttribute("listing")
    public ListingDto listingDto() {
        return new ListingDto();
    }

    @GetMapping("/new_listing")
    public String newListing() {
        // pass constraints
        // model.addAttribute("categories", categoryService.findAll());
        return "new_listing";
    }

    @PostMapping("/new_listing")
    public String createListing(@Valid @ModelAttribute("listing") ListingDto listingDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_listing";
        }

        // TODO add constraints and requests

        // retrieve logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userService.findByUsername(auth.getName());

        Listing listing = new Listing();
        listing.setOwner(owner);
        listing.setDescription(listingDto.getDescription());
        listing.setPhotos(listingDto.getPhotos());
        listing.setServices(listingDto.getServices());
        listing.setConstraints(listingDto.getConstrains());
        listing.setBookingInfo(listingDto.getBookingInfo());
        listing.setAvailabilityStart(listingDto.getAvailabilityStart());
        listing.setAvailabilityEnd(listingDto.getAvailabilityEnd());
        listing.setRating(0.0);
        listing.setOwnerRating(0.0);
        listing.setAddressLine(listingDto.getAddressLine());
        listing.setPremise(listingDto.getPremise());
        listing.setCity(listingDto.getCity());
        listing.setPostalCode(listingDto.getPostalCode());
        listing.setCountry(listingDto.getCountry());
        listingRepository.save(listing);

        return "redirect:/listing";
    }


     @PostMapping("/listing/delete/{id}") public String deleteListing(@PathVariable("id") long listingId) {
     Listing listing = listingRepository.findListingByListingId(listingId);
     if (listing != null) {
     listingRepository.deleteListingByListingId(listingId);
     logger.debug(String.format("Listing with id: %s has been successfully deleted.", listing.getListingId()));
     return "redirect:/home_page";
     } else {
     // add error pages
     return "error/404";
     }
     }
}
