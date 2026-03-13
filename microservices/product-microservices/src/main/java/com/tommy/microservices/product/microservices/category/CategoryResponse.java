package com.tommy.microservices.product.microservices.category;


import com.tommy.microservices.product.microservices.product.ProductResponse;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CategoryResponse(
        Integer id,
        String nombre,
        String descripcion,
        List<ProductResponse> productos) {
}
