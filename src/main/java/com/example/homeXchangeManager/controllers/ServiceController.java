package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ServiceDto;
import com.example.homeXchangeManager.models.Service;
import com.example.homeXchangeManager.service.impl.ServiceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ServiceController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
    private ServiceServiceImpl serviceService;

    @Autowired
    public ServiceController(ServiceServiceImpl serviceService) {
        this.serviceService = serviceService;
    }

    @ModelAttribute("service")
    public ServiceDto serviceDto() {
        return new ServiceDto();
    }

    @PostMapping("/service/new")
    public ResponseEntity<String> newService(@Valid @ModelAttribute("service") ServiceDto serviceDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            logger.debug(errorMessages);
            return new ResponseEntity<>("There was an error adding the service.", HttpStatus.BAD_REQUEST);
        }

        Service service = new Service();
        service.setServiceName(serviceDto().getServiceName());
        service.setServiceDescription(serviceDto().getServiceDescription());
        serviceService.save(service);

        return new ResponseEntity<>("Constraint added successfully!", HttpStatus.OK);
    }

}
