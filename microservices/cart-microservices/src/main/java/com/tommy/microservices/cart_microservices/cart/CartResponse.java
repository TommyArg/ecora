package com.tommy.microservices.cart_microservices.cart;

import com.tommy.microservices.cart_microservices.cartItem.CartItemResponse;

import java.util.List;

public record CartResponse(
        String id,
        String customerId,
        List<CartItemResponse> cartItems
){ }