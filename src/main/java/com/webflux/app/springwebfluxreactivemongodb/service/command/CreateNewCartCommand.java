package com.webflux.app.springwebfluxreactivemongodb.service.command;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.request.CreateNewCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.Command;

public interface CreateNewCartCommand extends Command<Cart, CreateNewCartRequest> {
}
