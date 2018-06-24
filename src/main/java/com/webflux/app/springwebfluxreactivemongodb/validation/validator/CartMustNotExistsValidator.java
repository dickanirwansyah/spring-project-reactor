package com.webflux.app.springwebfluxreactivemongodb.validation.validator;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.validation.CartMustNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class CartMustNotExistsValidator implements ConstraintValidator<CartMustNotExists, String> {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void initialize(CartMustNotExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        //return cartRepository.existsById(value).block() == Boolean.FALSE;
        return true;
    }
}
