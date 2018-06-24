package com.webflux.app.springwebfluxreactivemongodb.validation;


import com.webflux.app.springwebfluxreactivemongodb.validation.validator.CartMustNotExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CartMustNotExistsValidator.class})
@Documented
public @interface CartMustNotExists {

    String message() default "CartMustNotExists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
