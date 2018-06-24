package com.webflux.app.springwebfluxreactivemongodb.service.impl;

import com.webflux.app.springwebfluxreactivemongodb.model.request.ServiceRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.Command;
import com.webflux.app.springwebfluxreactivemongodb.service.ServiceExecutor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class ServiceExecutorImpl implements ServiceExecutor, ApplicationContextAware{

    private ApplicationContext applicationContext;


    @Override
    public <T, R extends ServiceRequest> Mono<T> execute(Class<? extends Command<T, R>> commandClass, R request) {
        Command<T, R> command = applicationContext.getBean(commandClass);
        return command.execute(request);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
