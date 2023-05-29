package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.service.impl.UserServiceImpl;
import com.example.homeXchangeManager.utils.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ListingController {
    private static final Logger logger = LoggerFactory.getLogger(ListingController.class);
    private ListingRepository listingRepository;
    private UserServiceImpl userService;

    @Autowired
    public ListingController(ListingRepository listingRepository, UserServiceImpl userService) {
        this.listingRepository = listingRepository;
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
        // TODO add constraints and requests

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
        Listing savedListing = listingRepository.save(listing);

        String uploadDir = "./listing-images/" + savedListing.getListingId();
        FileUploadUtil.saveFile(uploadDir, mainImg, mainImgName);
        FileUploadUtil.saveFile(uploadDir, scdImg, scdImgName);
        FileUploadUtil.saveFile(uploadDir, trdImg, trdImgName);

        return "redirect:/listing";
    }


    @PostMapping("/listing/delete/{id}")
    public String deleteListing(@PathVariable("id") long listingId) {
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

    private Byte[] convertToBytes(MultipartFile file) throws IOException {
        Byte[] byteObjects = new Byte[file.getBytes().length];
        int i = 0;
        for (byte b : file.getBytes()) {
            byteObjects[i++] = b;
        }
        return byteObjects;
    }

    @PostMapping("/listing/edit/{id}")
    public String editListing(@PathVariable("id") long listingId, @Valid @ModelAttribute("listing") ListingDto listingDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_listing";
        }

        Listing listing = listingRepository.findListingByListingId(listingId);
        if (listing != null) {
            listing.setDescription(listingDto.getDescription());
            listingRepository.save(listing);
            return "redirect:/home_page";
        } else {
            // Listing not found, handle the error appropriately
            return "error/404";
        }
    }

}
