package com.webflux.app.springwebfluxreactivemongodb.service;

import com.webflux.app.springwebfluxreactivemongodb.model.request.ServiceRequest;
import reactor.core.publisher.Mono;

public interface ServiceExecutor {

    <T, R extends ServiceRequest> Mono<T> execute(Class<? extends Command<T, R>> commandClass, R request);
}
