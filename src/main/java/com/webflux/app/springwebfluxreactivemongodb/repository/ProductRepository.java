package com.webflux.app.springwebfluxreactivemongodb.repository;

import com.webflux.app.springwebfluxreactivemongodb.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{
}
