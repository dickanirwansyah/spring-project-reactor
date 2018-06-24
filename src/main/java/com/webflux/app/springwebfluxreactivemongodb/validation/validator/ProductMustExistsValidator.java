package com.webflux.app.springwebfluxreactivemongodb.validation.validator;

import com.webflux.app.springwebfluxreactivemongodb.entity.Product;
import com.webflux.app.springwebfluxreactivemongodb.repository.ProductRepository;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductMustExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ProductMustExistsValidator implements ConstraintValidator<ProductMustExists, String>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductMustExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }

        Product product = productRepository.findById(value).block();
        return product != null;
    }
}
