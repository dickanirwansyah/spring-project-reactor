package com.webflux.app.springwebfluxreactivemongodb.service;

import com.webflux.app.springwebfluxreactivemongodb.model.request.ServiceRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.exception.CommandValidationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public abstract class AbstractCommand<RESULT, REQUEST extends ServiceRequest>
    implements Command<RESULT, REQUEST>, ApplicationContextAware, InitializingBean{

    protected Validator validator;

    protected ApplicationContext applicationContext;

    @Override
    public final void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        this.applicationContext = applicationContext;
    }

    @Override
    public final void afterPropertiesSet() throws Exception{
        this.validator = applicationContext.getBean(Validator.class);
    }


    @Override
    public final Mono<RESULT> execute(REQUEST request){
        Set<ConstraintViolation<REQUEST>> constraintViolations = validator.validate(request);
        if (constraintViolations.isEmpty()){
            return doExecute(request);
        }else{
            return Mono.error(new CommandValidationException(constraintViolations));
        }
    }

    public abstract Mono<RESULT> doExecute(REQUEST request);
}
