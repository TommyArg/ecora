package com.tommy.microservices.cart_microservices.cart;

import com.tommy.microservices.cart_microservices.exceptions.CartException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;


    public CartResponse getCartByCustomerId(String customerId) {

        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CartException("Carrito para el cliente de ID " + customerId + " no existe."));

        return cartMapper.toCartResponse(cart);
    }

    public void clearCart(String customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CartException("Carrito para el cliente de ID " + customerId + " no existe."));

        cartRepository.delete(cart);

    }}

