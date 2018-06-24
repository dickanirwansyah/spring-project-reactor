package com.webflux.app.springwebfluxreactivemongodb.service;

import com.webflux.app.springwebfluxreactivemongodb.model.request.ServiceRequest;
import reactor.core.publisher.Mono;

public interface Command<RESULT, REQUEST extends ServiceRequest> {

    Mono<RESULT> execute(REQUEST request);
}
