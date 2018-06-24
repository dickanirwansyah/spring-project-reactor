package com.webflux.app.springwebfluxreactivemongodb.model.request;

import com.webflux.app.springwebfluxreactivemongodb.validation.CartMustNotExists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewCartRequest implements ServiceRequest{

    @CartMustNotExists
    private String cartId;
}
