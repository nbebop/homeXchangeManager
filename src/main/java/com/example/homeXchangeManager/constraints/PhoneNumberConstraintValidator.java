package com.example.homeXchangeManager.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberConstraintValidator implements ConstraintValidator<PhoneNumberConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Skip validation if the value is null
        }
        String phoneNumberPattern = "^\\d{9}$";
        return value.matches(phoneNumberPattern);
    }
}

