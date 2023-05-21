package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.service.ListingService;
import com.example.homeXchangeManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private ListingService listingService;


    @Autowired
    public HomeController(UserService userService, ListingService listingService) {
        this.userService = userService;
        this.listingService = listingService;
    }

    @GetMapping({"/login", "/"})
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public String successLogin(Authentication authResult) {
        String role = authResult.getAuthorities().toString();

        if (role.contains("ADMIN")) {
            return "admin_page";
        } else if (role.contains("USER")) {
            return "home_page";
        }
        //fall back
        return "error/404";
    }

    @GetMapping("/listing")
    public String listing() {
        return "listing";
    }

    @GetMapping("/house")
    public String house() {
        return "house";
    }

    @GetMapping("/home_page")
    public String home_page(Model model) {
        model.addAttribute("listings", getAllListing());

        return "home_page";
    }

    /**
     * Controller to display listing images
     * and to display the image in frontend:
     * <img th:src="@{'/listing/image/' + ${listing.id}}">
     */
    @GetMapping("/listing/image/{id}")
    public ResponseEntity<Byte[]> displayItemImage(@PathVariable long id) {
        Listing listing = listingService.findByListingId(id);
        Byte[] image = listing.getImage();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    private List<Listing> getAllListing() {
        return listingService.findAll();
    }

}
