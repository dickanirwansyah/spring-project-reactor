package com.webflux.app.springwebfluxreactivemongodb.model.request;

import com.webflux.app.springwebfluxreactivemongodb.validation.CartMustExists;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductMustExists;
import com.webflux.app.springwebfluxreactivemongodb.validation.ProductMustExistsInCart;
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
@ProductMustExistsInCart(path = "productId")
@ProductQuantityMustEnough(path = "quantity")
public class UpdateProductInCartRequest implements ServiceRequest,
        ProductQuantityMustEnough.ProductQuantityUpdate,
        ProductMustExistsInCart.productInCart{

    @NotBlank
    @CartMustExists
    private String cartId;

    @NotBlank
    @ProductMustExists
    private String productId;

    @Min(0)
    @Max(10)
    private Integer quantity;
}
