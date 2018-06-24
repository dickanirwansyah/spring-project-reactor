package com.webflux.app.springwebfluxreactivemongodb.service.command;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.request.UpdateProductInCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.Command;

public interface UpdateProductFromCartCommand extends Command<Cart, UpdateProductInCartRequest> {
}
