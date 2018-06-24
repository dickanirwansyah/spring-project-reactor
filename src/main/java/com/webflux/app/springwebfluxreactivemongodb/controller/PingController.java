package com.webflux.app.springwebfluxreactivemongodb.controller;

import com.webflux.app.springwebfluxreactivemongodb.model.controller.Response;
import com.webflux.app.springwebfluxreactivemongodb.model.request.PingRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.ServiceExecutor;
import com.webflux.app.springwebfluxreactivemongodb.service.command.PingCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class PingController {

    private String applicationName = "ping hello";

    @Autowired
    private ServiceExecutor serviceExecutor;

    @GetMapping("/")
    public Mono<Response<String>> ping(){
        return Mono.just(Response.ok(applicationName))
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping("/ping")
    public Mono<Response<String>> pong() {
        PingRequest request = PingRequest.builder()
                .build();

        return serviceExecutor.execute(PingCommand.class, request)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
