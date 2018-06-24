package com.webflux.app.springwebfluxreactivemongodb.validation.validator;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.entity.CartItem;
import com.webflux.app.springwebfluxreactivemongodb.entity.Product;
import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.repository.ProductRepository;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductQuantityMustEnough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class ProductQuantityUpdateMustEnoughValidator
        implements ConstraintValidator<ProductQuantityMustEnough, ProductQuantityMustEnough.ProductQuantityUpdate>{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductQuantityMustEnough constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductQuantityMustEnough.ProductQuantityUpdate value, ConstraintValidatorContext context) {

        if (value == null || value.getProductId() == null || value.getQuantity() == null){
            return true;
        }

        Cart cart = cartRepository.findById(value.getCartId()).block();
        if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()){
            return true;
        }

        Optional<CartItem> cartItemOptional = getCartItemByProductId(cart, value.getProductId());
        if (!cartItemOptional.isPresent()){
            return true;
        }

        Product product = productRepository.findById(value.getProductId()).block();
        if (product == null){
            return false;
        }

        if (product.getStock() < value.getQuantity()){
            return false;
        }

        return product.getStock() >= (cartItemOptional.get().getQuantity() + value.getQuantity());
    }

    private Optional<CartItem> getCartItemByProductId(Cart cart, String productId){
        return cart.getItems().stream()
                .filter(cartItem -> cartItem.getId().equals(productId))
                .findFirst();
    }
}
