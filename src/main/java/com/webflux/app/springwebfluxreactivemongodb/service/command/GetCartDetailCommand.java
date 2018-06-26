package com.webflux.app.springwebfluxreactivemongodb.service.command;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.request.GetCartDetailRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.Command;

public interface GetCartDetailCommand extends Command<Cart, GetCartDetailRequest> {
}
