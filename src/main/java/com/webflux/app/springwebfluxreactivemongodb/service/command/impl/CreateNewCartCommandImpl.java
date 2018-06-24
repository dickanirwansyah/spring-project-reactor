package com.webflux.app.springwebfluxreactivemongodb.service.command.impl;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.request.CreateNewCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.service.AbstractCommand;
import com.webflux.app.springwebfluxreactivemongodb.service.command.CreateNewCartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateNewCartCommandImpl extends AbstractCommand<Cart, CreateNewCartRequest>
implements CreateNewCartCommand{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Mono<Cart> doExecute(CreateNewCartRequest request) {
        Cart cart = newCart(request.getCartId());
        return cartRepository.save(cart);
    }

    private Cart newCart(String id){
        return Cart.builder()
                .id(id)
                .build();
    }
}
