package com.webflux.app.springwebfluxreactivemongodb.model.request;

import com.webflux.app.springwebfluxreactivemongodb.validation.CartMustExists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCartDetailRequest implements ServiceRequest{

    @NotBlank
    @CartMustExists
    private String cartId;
}
