package com.webflux.app.springwebfluxreactivemongodb.validation.validator;

import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.validation.CartMustExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CartMustExistsValidator implements ConstraintValidator<CartMustExists, String>{


    @Autowired
    private CartRepository cartRepository;


    @Override
    public void initialize(CartMustExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }

        return cartRepository.existsById(value).block();
    }
}
