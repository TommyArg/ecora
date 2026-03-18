package com.tommy.microservices.product.microservices.product;


import com.tommy.microservices.product.microservices.category.Category;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductResponse toProductResponse(Product product) {
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

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .nombre(request.name())
                .descripcion(request.description())
                .precio(request.price())
                .stock(request.stock())
                .urlimagen(request.imageUrl())
                .categoria(Category.builder()
                        .id(request.categoryId())
                        .build())
                .build();
    }
}
