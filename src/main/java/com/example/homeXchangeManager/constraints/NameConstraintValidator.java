package com.example.homeXchangeManager.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameConstraintValidator implements ConstraintValidator<NameConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Skip validation if the value is null
        }
        // Pattern that allows only letters and spaces, with any number of parts (no numbers)
        String cityPattern = "^[A-Za-z]+(\\s[A-Za-z]+)*$";
        return value.matches(cityPattern);
    }
}

