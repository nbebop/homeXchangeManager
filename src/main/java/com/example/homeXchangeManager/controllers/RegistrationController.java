package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.UserRegistrationDto;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
/**
@Controller
@RequestMapping("/registration")
public class RegistrationController {


    public RegistrationController() {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {

        userService.save(registrationDto);
        return "redirect:/registration?success";
    }*/
@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@RequestParam String name,
                                          @RequestParam String surname,
                                          @RequestParam String email,
                                          @RequestParam Date dob,
                                          @RequestParam String phone,
                                          @RequestParam String address) {
        User user = new User();
        user.setUsername(email);
        user.setFirstName(name);
        user.setLastName(surname);
        user.setEmail(email);
        user.setPassword("Fernando Alonso GOAT"); // Idk what to do with the password if its not asked in registration
        user.setAge(calculateAge(dob));
        user.setPhoneNumber(phone);
        user.setProfileInfo("New user");

        userRepository.save(user);

        return "redirect:/index.html"; // or any other URL
    }

    // Helper methods
    /*
    private String generateRandomPassword() {

    }*/

    private int calculateAge(Date dob) {
        // Convert Date object to LocalDate
        LocalDate birthDate = dob.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        // Calculate age using current date
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);

        return period.getYears();
    }
}




