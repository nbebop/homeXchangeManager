package com.example.homeXchangeManager.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class BirthDateValidator implements ConstraintValidator<BirthDate, Date> {
    @Override
    public boolean isValid(final Date valueToValidate, final ConstraintValidatorContext context) {
        Calendar dateInCalendar = Calendar.getInstance();
        dateInCalendar.setTime(valueToValidate);

        return Calendar.getInstance().get(Calendar.YEAR) - dateInCalendar.get(Calendar.YEAR) >= 18;
    }
}
