package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.BookingDto;
import com.example.homeXchangeManager.models.Booking;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.service.impl.BookingServiceImpl;
import com.example.homeXchangeManager.service.impl.ListingServiceImpl;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    private final BookingServiceImpl bookingService;
    private final ListingServiceImpl listingService;
    private final UserServiceImpl userService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService, ListingServiceImpl listingService, UserServiceImpl userService) {
        this.bookingService = bookingService;
        this.listingService = listingService;
        this.userService = userService;
    }

    @ModelAttribute("booking")
    public BookingDto bookingDto() {
        return new BookingDto();
    }

    @GetMapping("/booking/new/{id}")
    public String newBooking(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        Listing listing = listingService.findByListingId(id);
        model.addAttribute("listing", listing);
        model.addAttribute("request", request);

        return "new_booking";
    }

    @GetMapping("/booking_history")
    public String checkBookings(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByUsername(auth.getName());
        Date date = new Date();

        model.addAttribute("allBookingsAsGuest", bookingService.findByGuest(currentUser));
        model.addAttribute("oldBookingsAsHost", bookingService.findByHostAndBookingRequestDateBefore(currentUser, date));
        return "booking_history";
    }

    @PostMapping("/booking/new/{listingId}")
    public String newBooking(@PathVariable("listingId") int listingId,@Valid @ModelAttribute("booking") BookingDto bookingDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            logger.debug(errorMessages);

            return "new_booking";
        }
        // logged in user is guest
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User guest = userService.findByUsername(auth.getName());
        // listing owner is host
        Listing listing = listingService.findByListingId(listingId);
        User host = listing.getOwner();
        Date currentDate = new Date();

        Booking booking = new Booking();
        booking.setGuest(guest);
        booking.setHost(host);
        booking.setListing(listing);
        booking.setBookingStart(bookingDto.getBookingStart());
        booking.setBookingEnd(bookingDto.getBookingEnd());
        booking.setBookingRequestDate(currentDate);
        booking.setAdditionalInfo(bookingDto.getAdditionalInfo());
        bookingService.save(booking);

        return "redirect:/home_page";
    }

    @PostMapping("/bookings/{bookingId}/accept")
    public String acceptBooking(@PathVariable int bookingId) {
        Booking booking = bookingService.findById(bookingId);
        booking.setAccepted(true);
        bookingService.save(booking);
        return "redirect:/bookings";
    }

    @PostMapping("/bookings/{bookingId}/deny")
    public String denyBooking(@PathVariable int bookingId) {
        Booking booking = bookingService.findById(bookingId);
        booking.setAccepted(false);
        bookingService.save(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/booking/{id}")
    public String booking(@PathVariable("id") long id, Model model) {
        Listing listing = listingService.findByListingId(id);
        model.addAttribute("listing", listing);
        return "new_booking";
    }

}