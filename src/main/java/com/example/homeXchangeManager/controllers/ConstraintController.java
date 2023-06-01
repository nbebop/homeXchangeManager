package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.dto.ConstraintDto;
import com.example.homeXchangeManager.models.Constraint;
import com.example.homeXchangeManager.service.impl.ConstraintServiceImpl;
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
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ConstraintController {
    private static final Logger logger = LoggerFactory.getLogger(ConstraintController.class);
    private ConstraintServiceImpl constraintService;

    @Autowired
    public ConstraintController(ConstraintServiceImpl constraintService) {
        this.constraintService = constraintService;
    }

    @ModelAttribute("constraint")
    public ConstraintDto constraintDto() {
        return new ConstraintDto();
    }

    @PostMapping("/constraint/new")
    public ResponseEntity<String> newConstraint(@RequestBody ConstraintDto constraintDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            logger.debug(errorMessages);
            return new ResponseEntity<>("There was an error adding the constraint.", HttpStatus.BAD_REQUEST);
        }

        Constraint constraint = new Constraint();
        constraint.setConstraintName(constraintDto().getConstraintName());
        constraint.setConstraintDescription(constraintDto().getConstraintDescription());
        constraintService.save(constraint);

        return new ResponseEntity<>("Constraint added successfully!", HttpStatus.OK);
    }
}