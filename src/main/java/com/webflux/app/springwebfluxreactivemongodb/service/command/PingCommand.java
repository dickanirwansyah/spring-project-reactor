package com.webflux.app.springwebfluxreactivemongodb.service.command;

import com.webflux.app.springwebfluxreactivemongodb.model.request.ServiceRequest;
import com.webflux.app.springwebfluxreactivemongodb.service.Command;

public interface PingCommand extends Command<String, ServiceRequest> {
}
