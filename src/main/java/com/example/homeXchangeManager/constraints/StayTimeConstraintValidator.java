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

        Date bookingStart = booking.getBookingStart();
        Date bookingEnd = booking.getBookingEnd();

        if (bookingStart == null || bookingEnd == null) {
            return true; // Skip validation if either booking start or end date is null
        }

        long stayDuration = Duration.between(bookingStart.toInstant(), bookingEnd.toInstant()).toDays();
        return stayDuration <= 90;
    }
}
