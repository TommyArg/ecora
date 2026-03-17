package com.tommy.microservices.cart_microservices.cartItem;

public record CartItemResponse(
    Integer productId,
    Integer quantity
) {

}