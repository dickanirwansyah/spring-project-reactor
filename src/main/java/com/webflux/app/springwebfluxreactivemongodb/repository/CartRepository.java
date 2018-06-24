package com.webflux.app.springwebfluxreactivemongodb.repository;

import com.webflux.app.springwebfluxreactivemongodb.entity.Cart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CartRepository extends ReactiveMongoRepository<Cart, String>{


}
