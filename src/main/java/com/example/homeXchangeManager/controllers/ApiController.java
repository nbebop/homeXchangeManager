package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.dto.LoginDto;
import com.example.homeXchangeManager.dto.RatingDto;
import com.example.homeXchangeManager.dto.RegisterDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.Role;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.repositories.RoleRepository;
import com.example.homeXchangeManager.repositories.UserRepository;
import com.example.homeXchangeManager.service.impl.ListingRatingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
@Controller
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private ListingRepository listingRepository;
    private PasswordEncoder passwordEncoder;

    private ListingRatingServiceImpl ratingService;

    @Autowired
    public ApiController(AuthenticationManager authenticationManager, UserRepository userRepository,
                         RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                         ListingRatingServiceImpl ratingService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.ratingService = ratingService;
    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<String> registerApi(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstname(registerDto.getLastname());
        user.setLastname(registerDto.getLastname());
        user.setEmail(registerDto.getEmail());
        user.setBirthdate(registerDto.getBirthdate());
        user.setPhoneNumber(registerDto.getPhoneNumber());
        user.setDescription(registerDto.getDescription());
        user.setAddressLine(registerDto.getAddressLine());
        user.setPremise(registerDto.getPremise());
        user.setCity(registerDto.getCity());
        user.setPostalCode(registerDto.getPostalCode());
        user.setCountry(registerDto.getCountry());
        user.setRoles(Collections.singletonList(new Role("USER")));

        userRepository.save(user);

        return new ResponseEntity<>("User registration successful!", HttpStatus.OK);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<String> loginApi(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("User signed success", HttpStatus.OK);
    }

    @PostMapping("/api/auth/listing/new")
    public ResponseEntity<String> newListingApi(@RequestBody ListingDto listingDto) {
        Listing listing = new Listing();
        listing.setDescription(listing.getDescription());
        listing.setAvailabilityStart(listingDto.getAvailabilityStart());
        listing.setAvailabilityEnd(listingDto.getAvailabilityEnd());
        listing.setBookingInfo(listingDto.getBookingInfo());
        listing.setAddressLine(listingDto.getAddressLine());
        listing.setPremise(listingDto.getPremise());
        listing.setCity(listingDto.getCity());
        listing.setPostalCode(listingDto.getPostalCode());
        listing.setCountry(listingDto.getCountry());

        return new ResponseEntity<>("Listing created success", HttpStatus.OK);
    }

    @PostMapping("/api/auth/listing/edit")
    public ResponseEntity<String> editListingApi(@RequestBody ListingDto listingDto) {

        return new ResponseEntity<>("Listing edit success", HttpStatus.OK);
    }

    @PostMapping("/api/auth/listing/delete")
    public ResponseEntity<String> deleteListingApi(@RequestBody ListingDto listingDto) {

        return new ResponseEntity<>("Listing deleted success", HttpStatus.OK);
    }

    @PostMapping("/api/listing/rate")
    public ResponseEntity<String> rateListingApi(@RequestBody RatingDto ratingDto) {
        logger.debug(ratingDto.toString());
        ratingService.save(ratingDto);

        return new ResponseEntity<>("Rating sent with success", HttpStatus.OK);
    }

}
