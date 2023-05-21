package com.example.homeXchangeManager.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostalCodeConstraintValidator implements ConstraintValidator<PostalCodeConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Skip validation if the value is null
        }
        // simple postal code pattern
        String postalCodePattern = "^\\d{5}$";
        return value.matches(postalCodePattern);
    }
}
