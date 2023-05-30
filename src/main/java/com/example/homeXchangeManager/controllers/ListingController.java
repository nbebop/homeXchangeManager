package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.service.impl.ConstraintServiceImpl;
import com.example.homeXchangeManager.service.impl.ListingServiceImpl;
import com.example.homeXchangeManager.service.impl.ServiceServiceImpl;
import com.example.homeXchangeManager.service.impl.UserServiceImpl;
import com.example.homeXchangeManager.utils.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ListingController {
    private static final Logger logger = LoggerFactory.getLogger(ListingController.class);
    private ListingServiceImpl listingService;
    private ListingRepository listingRepository;
    private UserServiceImpl userService;
    private ServiceServiceImpl serviceService;
    private ConstraintServiceImpl constraintService;

    @Autowired
    public ListingController(ListingServiceImpl listingService, UserServiceImpl userService, ServiceServiceImpl serviceService, ConstraintServiceImpl constraintService, ListingRepository listingRepository) {
        this.listingService = listingService;
        this.userService = userService;
        this.serviceService = serviceService;
        this.constraintService = constraintService;
        this.listingRepository = listingRepository;
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
     * th:src=@{${listing.getMainImgPath}})
     * th:src=@{${listing.getScdImgPath}})
     * th:src=@{${listing.getTrdImgPath}})
     */
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

        MultipartFile mainImg = listingDto.getMainImg();
        MultipartFile scdImg = listingDto.getScdImg();
        MultipartFile trdImg = listingDto.getTrdImg();

        // handle the images
        String mainImgName = StringUtils.cleanPath(mainImg.getOriginalFilename());
        String scdImgName = StringUtils.cleanPath(scdImg.getOriginalFilename());
        String trdImgName = StringUtils.cleanPath(trdImg.getOriginalFilename());

        Listing listing = new Listing();
        listing.setOwner(owner);
        listing.setDescription(listingDto.getDescription());

        listing.setMainImg(mainImgName);
        listing.setScdImg(scdImgName);
        listing.setTrdImg(trdImgName);

        listing.setServices(listingDto.getServices());
        listing.setConstraints(listingDto.getConstraints());
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
        Listing savedListing = listingRepository.save(listing);

        String uploadDir = "./listing-images/" + savedListing.getListingId();
        FileUploadUtil.saveFile(uploadDir, mainImg, mainImgName);
        FileUploadUtil.saveFile(uploadDir, scdImg, scdImgName);
        FileUploadUtil.saveFile(uploadDir, trdImg, trdImgName);

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

    // Not sure about this one
    /*@GetMapping("/listings/search/{city}")
    public List<Listing> searchListingsByCity(@PathVariable("city") String city) {

        return listingRepository.findAllByCity(city);
    }*/

    @GetMapping("/listings/city")
    public String listingsByCity(Model model, @RequestParam String city) {
        List<Listing> listings = listingRepository.findAllByCity(city);
        model.addAttribute("listings", listings);
        return "listings";
    }

    @GetMapping("/listings/city/availability")
    public String listingsByCityAndAvailability(Model model, @RequestParam String city, @RequestParam Date start, @RequestParam Date end) {
        List<Listing> listings = listingRepository.findAllByCityAndAvailabilityStartBetween(city, start, end);
        model.addAttribute("listings", listings);
        return "listings";
    }

}
