package com.tommy.microservices.cart_microservices.cartItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CartItemRequest(
        @NotNull(message="El id/producto es inválido")
        String productId,
        @Min(value=1, message="Se requiere de mínimo 1 producto")
        Integer quantity
) {}
