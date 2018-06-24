package com.webflux.app.springwebfluxreactivemongodb.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cart")
public class Cart {

    private String id;

    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems(){
        if (items == null || items.isEmpty()){
            items = new ArrayList<>();
        }
        return items;
    }
}
