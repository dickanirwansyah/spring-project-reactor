package com.webflux.app.springwebfluxreactivemongodb.validation.validator;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductMustExistsInCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ProductMustExistsInCartValidator implements
        ConstraintValidator<ProductMustExistsInCart, ProductMustExistsInCart.productInCart>{

    @Autowired
    private CartRepository cartRepository;


    @Override
    public void initialize(ProductMustExistsInCart constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductMustExistsInCart.productInCart value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }

        Cart cart = cartRepository.findById(value.getCartId()).block();
        if (cart == null){
            return true;
        }

        if (cart.getItems() == null || cart.getItems().isEmpty()){
            return false;
        }

        return cart.getItems().stream()
                .anyMatch(cartItem -> cartItem.getId().equals(value.getProductId()));
    }
}
