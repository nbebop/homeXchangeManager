package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.RegisterDto;
import com.example.homeXchangeManager.models.Role;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.RoleRepository;
import com.example.homeXchangeManager.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
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

    @PostMapping
    public String register(@Valid @ModelAttribute("user") RegisterDto registerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            logger.debug("Binding error messages: " + errorMessages);

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

        Role roles = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singletonList(roles));

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userRepository.save(user);
        redirectAttributes.addFlashAttribute("successMessage", "Listing created successfully!");
        return "login";
    }


}
