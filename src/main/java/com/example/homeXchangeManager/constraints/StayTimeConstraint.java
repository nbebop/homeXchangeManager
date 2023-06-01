package com.example.homeXchangeManager.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StayTimeConstraintValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface StayTimeConstraint {
    String message() default "The stay time must not exceed 90 days.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
