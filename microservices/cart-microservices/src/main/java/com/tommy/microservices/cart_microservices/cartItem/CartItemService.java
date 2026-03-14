package com.tommy.microservices.cart_microservices.cartItem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService {
    public String addItemToCart(String customerId, CartItemRequest cartItemRequest) {
        throw new UnsupportedOperationException("No disponible aún.");
    }
}
