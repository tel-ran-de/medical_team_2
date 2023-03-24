package com.example.health_checker.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PositiveIntegerConstraint.class})
public @interface PositiveInteger {

    String message() default "Invalid number entered,has to be positive and less then 220";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}