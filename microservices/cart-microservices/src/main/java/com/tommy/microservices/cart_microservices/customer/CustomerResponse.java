package com.tommy.microservices.cart_microservices.customer;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String dni,
        String nombre,
        String apellido,
        String email
) {
}

