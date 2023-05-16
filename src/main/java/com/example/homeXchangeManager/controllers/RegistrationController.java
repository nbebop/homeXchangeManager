package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.RegisterDto;
import com.example.homeXchangeManager.models.Role;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.RoleRepository;
import com.example.homeXchangeManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("user")
    public RegisterDto registerDto() {
        return new RegisterDto();
    }

    @GetMapping
    public String register() {
        return "registration";
    }

    // for the date

    @PostMapping
    public String register(@Valid @ModelAttribute("user") RegisterDto registerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
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
        // anyone who registers is a user
        user.setRoles(Collections.singletonList(new Role("USER")));

        userRepository.save(user);
        return "login";
    }

}
