package com.tommy.microservices.product.microservices.product;

public record ProductResponse(
        Integer id,
        String nombre,
        String descripcion,
        Double precio,
        Integer stock,
        String urlimagen,
        Integer idCategoria,
        String categoryNombre,
        String categoryDescripcion
)
{}
