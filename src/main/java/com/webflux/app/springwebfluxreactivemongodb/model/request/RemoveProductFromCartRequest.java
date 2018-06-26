package com.webflux.app.springwebfluxreactivemongodb.model.request;

import com.webflux.app.springwebfluxreactivemongodb.validation.CartMustExists;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductMustExists;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductMustExistsInCart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ProductMustExistsInCart(path = "productId")
public class RemoveProductFromCartRequest implements ServiceRequest{
        //ProductMustExistsInCart.productInCart {

    @NotBlank
    //@CartMustExists
    private String cartId;

    @NotBlank
    //@ProductMustExists
    private String productId;
}
