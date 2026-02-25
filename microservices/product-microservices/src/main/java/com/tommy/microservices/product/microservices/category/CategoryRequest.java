package com.tommy.microservices.product.microservices.category;

import com.tommy.microservices.product.microservices.product.ProductResponse;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CategoryRequest(
        Integer id,
        @NotBlank(message = "Nombre requerido")
        String nombre,
        String descripcion,
        List<ProductResponse> products
        ) {
}
