package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.UserRepository;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private UserRepository userRepository;
    private UserService userService;
    private ListingService listingService;

    @Autowired
    public AdminController(UserService userService, ListingService listingService, UserRepository userRepository) {
        this.userService = userService;
        this.listingService = listingService;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/admin_page")
    public String adminPage(Model model,
                            @RequestParam(name = "sort", required = false) String sort,
                            @RequestParam(name = "order", defaultValue = "asc") String order,
                            HttpSession session) {
        Sort.Direction currentSortDirection = getSessionSortDirection(session);
        Sort.Direction newSortDirection = currentSortDirection;

        if (sort != null && (sort.equals("city") || sort.equals("description"))) {
            currentSortDirection = toggleSortDirection(currentSortDirection);
            newSortDirection = currentSortDirection;
            updateSessionSortDirection(session, currentSortDirection);
        }

        Sort sortObject = Sort.by(newSortDirection, sort != null ? sort : "city");
        if (order.equals("desc")) {
            sortObject = sortObject.descending();
        }

        model.addAttribute("listings", getAllListing(sortObject));
        model.addAttribute("users", getAllUsers(sortObject));
        model.addAttribute("currentSortDirection", currentSortDirection);
        return "admin_page";
    }


    @PostMapping("/admin/delete/listing")
    public String deleteListing(@RequestParam(name = "listing_id") long listingId, Model model) {
        Listing listing = listingService.findByListingId(listingId);
        if (listing != null) {
            listingService.delete(listingId);
            logger.debug(String.format("Listing with id: %s has been successfully deleted.", listing.getListingId()));
            return "redirect:/admin/admin_page";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/admin/delete/user")
    public String deleteUser(@RequestParam(name = "user_id") long userId, Model model) {
        User user = userService.findById(userId);

        if (user != null) {
            userService.delete(userId);
            logger.debug(String.format("User with id: %s has been successfully deleted.", user.getId()));
            return "redirect:/admin/admin_page";
        } else {
            return "error/404";
        }
    }

    @GetMapping("/admin/edit/listing/{id}")
    public String editListing(@PathVariable("id") long listingId, Model model) {
        Listing listing = listingService.findByListingId(listingId);
        if (listing != null) {
            model.addAttribute("listing", listing);
            return "edit_listing";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/admin/update/listing")
    public String updateListing(@ModelAttribute("listing") Listing updatedListing) {
        Listing existingListing = listingService.findByListingId(updatedListing.getListingId());
        if (existingListing != null) {
            // Update the listing details
            existingListing.setDescription(updatedListing.getDescription());
            // Update more listing details

            // Convert the existingListing to a ListingDto
            ListingDto listingDto = convertToDto(existingListing);

            // Save the ListingDto
            listingService.save(listingDto);

            logger.debug(String.format("Listing with id: %s has been successfully updated.", existingListing.getListingId()));
            return "redirect:/admin_page";
        } else {
            return "error/404";
        }
    }

    private ListingDto convertToDto(Listing listing) {
        ListingDto listingDto = new ListingDto();
        // Convert listing properties to listingDto properties
        listingDto.setListingId(listing.getListingId());
        listingDto.setDescription(listing.getDescription());
        // Convert more properties

        return listingDto;
    }


    private Sort.Direction getSessionSortDirection(HttpSession session) {
        Sort.Direction currentSortDirection = (Sort.Direction) session.getAttribute("sortDirection");
        return currentSortDirection != null ? currentSortDirection : Sort.Direction.ASC;
    }

    private Sort.Direction toggleSortDirection(Sort.Direction currentSortDirection) {
        return currentSortDirection == Sort.Direction.ASC ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

    private void updateSessionSortDirection(HttpSession session, Sort.Direction currentSortDirection) {
        session.setAttribute("sortDirection", currentSortDirection);
    }


    private List<User> getAllUsers(Sort sort) {
        return userRepository.findAll(sort);
    }

    private List<Listing> getAllListing(Sort sort) {
        return listingService.findAll(sort);
    }
}
