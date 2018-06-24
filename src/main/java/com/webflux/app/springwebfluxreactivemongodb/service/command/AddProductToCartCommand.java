package com.webflux.app.springwebfluxreactivemongodb.service.command;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.request.AddProductToCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.Command;

public interface AddProductToCartCommand extends Command<Cart,AddProductToCartRequest>{
}
