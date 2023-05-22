package com.example.homeXchangeManager.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<PasswordConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Skip validation if the value is null
        }
        // Password must have at least 8 characters, including at least one uppercase letter, one lowercase letter, and one digit
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return value.matches(passwordPattern);
    }
}

