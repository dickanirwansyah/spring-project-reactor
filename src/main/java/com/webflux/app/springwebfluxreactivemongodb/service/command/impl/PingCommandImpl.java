package com.webflux.app.springwebfluxreactivemongodb.service.command.impl;

import com.webflux.app.springwebfluxreactivemongodb.model.request.ServiceRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.AbstractCommand;
import com.webflux.app.springwebfluxreactivemongodb.service.command.PingCommand;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PingCommandImpl extends AbstractCommand<String, ServiceRequest> implements PingCommand{


    @Override
    public Mono<String> doExecute(ServiceRequest request) {
        return Mono.just("PONG");
    }
}
