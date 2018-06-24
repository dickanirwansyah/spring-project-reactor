package com.webflux.app.springwebfluxreactivemongodb.model.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRemoveProductRequest {

    private String productId;
}
