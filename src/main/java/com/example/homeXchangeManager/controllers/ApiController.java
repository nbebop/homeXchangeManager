package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.dto.LoginDto;
import com.example.homeXchangeManager.dto.MessageDto;
import com.example.homeXchangeManager.dto.RegisterDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.Role;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.repositories.MessageRepository;
import com.example.homeXchangeManager.repositories.RoleRepository;
import com.example.homeXchangeManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ApiController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private ListingRepository listingRepository;
    private PasswordEncoder passwordEncoder;
    private MessageRepository messageRepository;

    @Autowired
    public ApiController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, MessageRepository messageRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.messageRepository = messageRepository;
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

    @PostMapping("/api/chat/send")
    public ResponseEntity<String> sendMessageApi(@RequestBody MessageDto messageDto){

        String senderName = messageDto.getSender();
        String receiverName = messageDto.getReceiver();

        Optional<User> optionalSender = userRepository.findByUsername(senderName);
        Optional<User> optionalReceiver = userRepository.findByUsername(receiverName);

        User sender = new User();;
        if(optionalSender.isPresent()){
            sender = userRepository.getById(optionalSender.get().getId());
        }

        User receiver = new User();
        if(optionalReceiver.isPresent()){
            receiver = userRepository.getById(optionalReceiver.get().getId());
        }

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(messageDto.getContent());

        LocalDateTime currentDateTime = LocalDateTime.now(); // Get the current date and time

        // Convert LocalDateTime to Date
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = currentDateTime.atZone(zoneId).toInstant();
        Date currentDate = Date.from(instant);
        message.setTimestamp(currentDate);

        messageRepository.save(message);

        return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
    }

    @PostMapping("/api/chat/message/")
    public ResponseEntity<List<Message>> getChatMessagesApi(@RequestBody MessageDto messageDto){
        Optional<User> optionalSender = userRepository.findByUsername(messageDto.getSender());
        Optional<User> optionalReceiver = userRepository.findByUsername(messageDto.getReceiver());

        if (optionalSender.isEmpty() || optionalReceiver.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User sender = optionalSender.get();
        User receiver = optionalReceiver.get();

        List<Message> messages = messageRepository.findBySenderAndReceiverOrReceiverAndSenderOrderByTimestamp(sender, receiver, receiver, sender);

        return new ResponseEntity<>(messages, HttpStatus.OK);


    }
}
