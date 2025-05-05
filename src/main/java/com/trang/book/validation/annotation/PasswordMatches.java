package com.trang.book.validation.annotation;

import com.trang.book.validation.validator.PasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Confirmation password does not match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
