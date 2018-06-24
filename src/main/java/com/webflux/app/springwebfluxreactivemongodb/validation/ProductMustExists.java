package com.webflux.app.springwebfluxreactivemongodb.validation;

import com.webflux.app.springwebfluxreactivemongodb.validation.validator.ProductMustExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;


@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Constraint(validatedBy = {ProductMustExistsValidator.class})
@Retention(RUNTIME)
@Documented
public @interface ProductMustExists {

    String message() default "ProductMustExists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
