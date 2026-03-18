package com.tommy.microservices.product.microservices.product;

import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Nombre de producto no puede estar vacío.")
        String name,
        String description,
        @NotNull(message = "Precio del producto no puede estar nulo.")
        Double price,
        Integer stock,
        String imageUrl,
        @NotNull(message = "Id de la categoría no puede ser nulo.")
        Integer categoryId
) {
}
