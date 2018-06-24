package com.webflux.app.springwebfluxreactivemongodb.service.command;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.request.RemoveProductFromCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.Command;

public interface RemoveProductFromCartCommand extends Command<Cart, RemoveProductFromCartRequest> {
}
