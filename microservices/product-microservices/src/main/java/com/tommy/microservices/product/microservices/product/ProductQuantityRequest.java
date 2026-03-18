package com.tommy.microservices.product.microservices.product;

import jakarta.validation.constraints.NotNull;

public record ProductQuantityRequest(
        @NotNull(message = "Id del producto no puede ser nulo.")
        Integer productId,
        @NotNull(message = "La cantidad no puede ser nula.")
        Integer quantity
) {
}
