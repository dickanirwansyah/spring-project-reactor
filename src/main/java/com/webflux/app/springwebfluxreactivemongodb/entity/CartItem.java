package com.webflux.app.springwebfluxreactivemongodb.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    private String id;

    private String name;

    private Long price;

    private Integer quantity;
}
