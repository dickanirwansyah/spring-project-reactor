package com.webflux.app.springwebfluxreactivemongodb.service.command.impl;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.entity.CartItem;
import com.webflux.app.springwebfluxreactivemongodb.model.request.RemoveProductFromCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.service.AbstractCommand;

import com.webflux.app.springwebfluxreactivemongodb.service.command.RemoveProductFromCartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RemoveProductFromCartCommandImpl extends AbstractCommand<Cart, RemoveProductFromCartRequest>
implements RemoveProductFromCartCommand{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Mono<Cart> doExecute(RemoveProductFromCartRequest request) {
        return cartRepository.findById(request.getCartId())
                .map(cart -> findCartItemAndRemoveIt(cart, request.getProductId()))
                .flatMap(cart -> cartRepository.save(cart));
    }

    private Cart findCartItemAndRemoveIt(Cart cart,String productId){
        CartItem cartItem = findItemInCart(cart, productId);
        return removeItemFromCart(cart, cartItem);
    }

    private CartItem findItemInCart(Cart cart, String productId){
        return cart.getItems().stream()
                .filter(cartItem -> cartItem.getId().equals(productId))
                .findFirst().get();
    }

    private Cart removeItemFromCart(Cart cart, CartItem cartItem){
        cart.getItems().remove(cartItem);
        return cart;
    }
}
