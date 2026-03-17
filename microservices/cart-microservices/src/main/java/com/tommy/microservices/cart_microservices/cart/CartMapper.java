package com.tommy.microservices.cart_microservices.cart;

import com.tommy.microservices.cart_microservices.cartItem.CartItem;
import com.tommy.microservices.cart_microservices.cartItem.CartItemResponse;

import java.util.ArrayList;
import java.util.List;

public class CartMapper {

    public CartResponse toCartResponse(Cart cart) {

        List<CartItemResponse> cartItemResponses = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            cartItemResponses.add(new CartItemResponse(
                    item.getProductId(),
                    item.getQuantity()
            ));
        }

        return new CartResponse(cart.getId(), cart.getCustomerId(), cartItemResponses);
    }

}