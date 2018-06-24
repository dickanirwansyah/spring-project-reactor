package com.webflux.app.springwebfluxreactivemongodb.service.command.impl;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.entity.CartItem;
import com.webflux.app.springwebfluxreactivemongodb.entity.Product;
import com.webflux.app.springwebfluxreactivemongodb.model.request.AddProductToCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.repository.ProductRepository;
import com.webflux.app.springwebfluxreactivemongodb.service.AbstractCommand;
import com.webflux.app.springwebfluxreactivemongodb.service.command.AddProductToCartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AddProductToCartCommandImpl extends AbstractCommand<Cart, AddProductToCartRequest>
implements AddProductToCartCommand{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Mono<Cart> doExecute(AddProductToCartRequest request) {
        return Mono.zip(
                objects -> addOrUpdateProductInCart((Cart) objects[0],
                        (Product) objects[1], request.getQuantity()),
                cartRepository.findById(request.getCartId()),
                productRepository.findById(request.getProductId())
        ).flatMap(cart -> cartRepository.save(cart));
    }

    private Cart addOrUpdateProductInCart(Cart cart, Product product, Integer quantity){
        if (isCartContaintProduct(cart, product)){
            incrementProductQuantity(cart, product, quantity);
        }else {
            addNewProductToCart(cart, product, quantity);
        }
        return cart;
    }

    private boolean isCartContaintProduct(Cart cart, Product product){
        return cart.getItems().stream()
                .anyMatch(cartItem -> cartItem.getId().equals(product.getId()));
    }

    private void incrementProductQuantity(Cart cart, Product product, Integer quantity){
        cart.getItems().stream()
                .filter(cartItem -> cartItem.getId().equals(product.getId()))
                .forEach(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
    }

    private void addNewProductToCart(Cart cart, Product product, Integer quantity){
        CartItem item = CartItem.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(quantity)
                .build();

        cart.getItems().add(item);
    }
}
