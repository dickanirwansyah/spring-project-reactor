package com.webflux.app.springwebfluxreactivemongodb.validation;


import com.webflux.app.springwebfluxreactivemongodb.validation.validator.CartMustExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Constraint(validatedBy = {CartMustExistsValidator.class})
@Retention(RUNTIME)
@Documented
public @interface CartMustExists {

    String message() default "CartMustExists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
