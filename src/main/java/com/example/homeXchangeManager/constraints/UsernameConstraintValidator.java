package com.example.homeXchangeManager.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameConstraintValidator implements ConstraintValidator<UsernameConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Skipping validation if the value is null
        }
        return value.matches("^[a-zA-Z0-9_]+$"); // Example: Only allow alphanumeric characters and underscores
    }
}
