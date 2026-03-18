package com.tommy.microservices.product.microservices.category;

import com.tommy.microservices.product.microservices.product.ProductMapper;
import com.tommy.microservices.product.microservices.product.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public Category toCategory(CategoryRequest request) {
        return Category.builder()
                .id(request.id())
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getNombre(),
                category.getDescripcion(),
                category.getProductos().stream()
                        .map(product -> new ProductResponse(
                                product.getId(),
                                product.getNombre(),
                                product.getDescripcion(),
                                product.getPrecio(),
                                product.getStock(),
                                product.getUrlimagen(),
                                product.getCategoria().getId(),
                                product.getCategoria().getNombre(),
                                product.getCategoria().getDescripcion(
                                )))
                        .toList()
        );
    }
}