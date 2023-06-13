package com.example.homeXchangeManager.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RatingConstraintValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RatingConstraint {
    String message() default "Invalid rating value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

