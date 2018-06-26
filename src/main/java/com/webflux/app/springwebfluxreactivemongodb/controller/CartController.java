package com.webflux.app.springwebfluxreactivemongodb.controller;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import com.webflux.app.springwebfluxreactivemongodb.model.controller.CartAddProductRequest;
import com.webflux.app.springwebfluxreactivemongodb.model.controller.Response;
import com.webflux.app.springwebfluxreactivemongodb.model.request.AddProductToCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.model.request.CreateNewCartRequest;
import com.webflux.app.springwebfluxreactivemongodb.model.request.GetCartDetailRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.ServiceExecutor;
import com.webflux.app.springwebfluxreactivemongodb.service.command.AddProductToCartCommand;
import com.webflux.app.springwebfluxreactivemongodb.service.command.CreateNewCartCommand;
import com.webflux.app.springwebfluxreactivemongodb.service.command.GetCartDetailCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    @Autowired
    private ServiceExecutor serviceExecutor;

    @PostMapping(path = "/{cartId}")
    public Mono<Response<Cart>> create(@PathVariable("cartId") String cartId){
        CreateNewCartRequest request = CreateNewCartRequest.builder()
                .cartId(cartId)
                .build();

        return serviceExecutor.execute(CreateNewCartCommand.class, request)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(value = "/{cartId}")
    public Mono<Response<Cart>> detail(@PathVariable("cartId") String cartId){
        GetCartDetailRequest request = GetCartDetailRequest
                .builder()
                .cartId(cartId)
                .build();

        return serviceExecutor.execute(GetCartDetailCommand.class, request)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @PostMapping(value = "/{cartId}/_add-product")
    public Mono<Response<Cart>> addProduct(@PathVariable("cartId")String cartId,
                                           @RequestBody CartAddProductRequest requestBody){

        AddProductToCartRequest request = AddProductToCartRequest.builder()
                .cartId(cartId)
                .productId(requestBody.getProductId())
                .quantity(requestBody.getQuantity())
                .build();

        return serviceExecutor.execute(AddProductToCartCommand.class, request)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
