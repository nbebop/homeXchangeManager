package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.service.impl.ConstraintServiceImpl;
import com.example.homeXchangeManager.service.impl.ListingServiceImpl;
import com.example.homeXchangeManager.service.impl.ServiceServiceImpl;
import com.example.homeXchangeManager.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ListingController {
    private static final Logger logger = LoggerFactory.getLogger(ListingController.class);
    private ListingServiceImpl listingService;
    private UserServiceImpl userService;
    private ServiceServiceImpl serviceService;
    private ConstraintServiceImpl constraintService;

    @Autowired
    public ListingController(ListingServiceImpl listingService, UserServiceImpl userService, ServiceServiceImpl serviceService, ConstraintServiceImpl constraintService) {
        this.listingService = listingService;
        this.userService = userService;
        this.serviceService = serviceService;
        this.constraintService = constraintService;
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

    @PostMapping("/new_listing")
    public String createListing(@Valid @ModelAttribute("listing") ListingDto listingDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            logger.debug(errorMessages);

            return "new_listing";
        }

        // retrieve logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userService.findByUsername(auth.getName());

        // get img in bytes
        Byte[] bytesImg = convertToBytes(listingDto.getImage());

        Listing listing = new Listing();
        listing.setOwner(owner);
        listing.setDescription(listingDto.getDescription());
        listing.setImage(bytesImg);
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
        listingService.save(listing);

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
    public String editListing(@PathVariable("id") long listingId, @Valid @ModelAttribute("listing") ListingDto listingDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_listing";
        }

        Listing listing = listingService.findByListingId(listingId);
        if (listing != null) {
            listing.setDescription(listingDto.getDescription());
            listingService.save(listing);
            return "redirect:/home_page";
        } else {
            // Listing not found, handle the error appropriately
            return "error/404";
        }
    }

    private Byte[] convertToBytes(MultipartFile file) throws IOException {
        Byte[] byteObjects = new Byte[file.getBytes().length];
        int i = 0;
        for (byte b : file.getBytes()) {
            byteObjects[i++] = b;
        }
        return byteObjects;
    }

}
