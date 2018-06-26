package com.webflux.app.springwebfluxreactivemongodb.service.command.impl;


import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.request.GetCartDetailRequest;
import com.webflux.app.springwebfluxreactivemongodb.repository.CartRepository;
import com.webflux.app.springwebfluxreactivemongodb.service.AbstractCommand;
import com.webflux.app.springwebfluxreactivemongodb.service.command.GetCartDetailCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetCartDetailCommandImpl extends AbstractCommand<Cart, GetCartDetailRequest> implements GetCartDetailCommand{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Mono<Cart> doExecute(GetCartDetailRequest request) {
        return cartRepository.findById(request.getCartId());
    }
}
