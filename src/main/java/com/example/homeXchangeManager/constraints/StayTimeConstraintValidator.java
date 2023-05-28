package com.example.homeXchangeManager.constraints;

import com.example.homeXchangeManager.models.Booking;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.util.Date;

public class StayTimeConstraintValidator implements ConstraintValidator<StayTimeConstraint, Booking> {

    @Override
    public boolean isValid(Booking booking, ConstraintValidatorContext context) {
        if (booking == null) {
            return true; // Skip validation if the booking is null
        }

        Date bookingStartDate = booking.getBookingStart();
        Date bookingEndDate = booking.getBookingEnd();

        if (bookingStartDate == null || bookingEndDate == null) {
            return true; // Skip validation if either start or end date is null
        }

        // Calculate the duration between the start and end date
        long milliseconds = bookingEndDate.getTime() - bookingStartDate.getTime();
        long days = milliseconds / (24 * 60 * 60 * 1000);

        // Check if the duration exceeds 90 days
        return days <= 90;
    }
}
