package com.webflux.app.springwebfluxreactivemongodb.model.request;

import com.webflux.app.springwebfluxreactivemongodb.validation.CartMustExists;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductMustExists;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductQuantityMustEnough;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ProductQuantityMustEnough(path = "quantity")
public class AddProductToCartRequest implements ServiceRequest{// ProductQuantityMustEnough.ProductQuantity{

    @NotBlank
    //@CartMustExists
    private String cartId;

    @NotBlank
    //@ProductMustExists
    private String productId;

    @Max(10)
    @Min(1)
    private Integer quantity;
}
