package com.tommy.microservices.product.microservices.product;


import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public static ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getNombre(),
                product.getDescripcion(),
                product.getPrecio(),
                product.getStock(),
                product.getUrlimagen(),
                product.getCategoria().getId(),
                product.getCategoria().getNombre(),
                product.getCategoria().getDescripcion()


        );
    }
}
