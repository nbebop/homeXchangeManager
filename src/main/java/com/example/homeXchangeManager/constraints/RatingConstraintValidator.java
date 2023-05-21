package com.example.homeXchangeManager.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RatingConstraintValidator implements ConstraintValidator<RatingConstraint, Double> {
    private static final double MIN_RATING = 0.0;
    private static final double MAX_RATING = 5.0;

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Skip validation if the value is null
        }
        // Check if the rating is within the valid range
        return value >= MIN_RATING && value <= MAX_RATING;
    }
}

