package com.webflux.app.springwebfluxreactivemongodb.validation.validator;

import com.webflux.app.springwebfluxreactivemongodb.entity.Product;
import com.webflux.app.springwebfluxreactivemongodb.repository.ProductRepository;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductQuantityMustEnough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ProductQuantityMustEnoughValidator
        implements ConstraintValidator<ProductQuantityMustEnough, ProductQuantityMustEnough.ProductQuantity>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductQuantityMustEnough constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductQuantityMustEnough.ProductQuantity value, ConstraintValidatorContext context) {
        if (value == null || value.getProductId() == null || value.getQuantity() == null){
            return true;
        }

        Product product = productRepository.findById(value.getProductId()).block();

        if (isProductNotExists(product)){
            return true;
        }

        return isStockEnough(product, value.getQuantity());

    }

    private boolean isProductNotExists(Product product){
        return product == null;
    }

    private boolean isStockEnough(Product product, Integer quantity){
        return product.getStock() >= quantity;
    }
}
