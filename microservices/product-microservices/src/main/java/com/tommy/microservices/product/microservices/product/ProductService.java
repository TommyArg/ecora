package com.tommy.microservices.product.microservices.product;


import com.tommy.microservices.product.microservices.category.CategoryService;
import com.tommy.microservices.product.microservices.exceptions.ProductException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final ProductMapper mapper;

    public List<ProductResponse> getProducts() {
        return repository.findAll().stream()
                .map(mapper::toProductResponse)
                .toList();
    }

    public ProductResponse getProductById(Integer id) {
        if (id == null) {
            throw new ProductException("Id de producto no puede estar vacío");
        }
        return repository.findById(id)
                .map(mapper::toProductResponse)
                .orElse(null);
    }

    public List<ProductResponse> getProductsByCategoryId(Integer id) {
        if (id == null) {
            throw new ProductException("Id de categoria no puede estar vacío.");
        }
        return repository.findAll().stream()
                .filter(product -> product.getCategoria().getId().equals(id))
                .map(mapper::toProductResponse)
                .toList();
    }


    public Integer updateProduct(ProductRequest request) {
        if (request.id() == null) {
            throw new ProductException("Id de producto no puede ser nulo.");
        }

        if (categoryService.getCategoryById(request.categoryId()) == null) {
            throw new ProductException("Categoria con id %s no encontrada.".formatted(request.categoryId()));
        }

        Product existingProduct = repository.findById(request.id())
                .orElseThrow(() -> new ProductException("Producto con id %s no encontrado.".formatted(request.id())));

        Product updatedProduct = mapper.toProduct(request);

        updatedProduct.setStock(existingProduct.getStock());

        repository.save(updatedProduct);
        return updatedProduct.getId();
    }

    public void deleteProduct(Integer id) {
        if (id == null) {
            throw new ProductException("Id de producto no puede ser nulo.");
        }
        if (!repository.existsById(id)) {
            throw new ProductException("Producto con el id %s no encontrado".formatted(id));
        }
        repository.deleteById(id);
    }

    public Integer createProduct(ProductRequest product) {

        if (categoryService.getCategoryById(product.categoryId()) == null) {
            throw new ProductException("Categoria con id %s no encontrada.".formatted(product.categoryId()));
        }

        Product newProduct = mapper.toProduct(product);
        Product savedProduct = repository.save(newProduct);
        return savedProduct.getId();
    }

    @Transactional
    public void purchaseProduct(List<ProductQuantityRequest> request) {
        for (ProductQuantityRequest item : request) {

            Product product = repository.findById(item.productId())
                    .orElseThrow(() -> new ProductException("Producto con id %s no encontrado.".formatted(item.productId())));

            if (item.quantity() < 0) {
                throw new ProductException("Cantidad de restock no puede ser negativa para producto de id %s".formatted(item.productId()));
            }

            if (product.getStock() < item.quantity()) {
                throw new ProductException("Stock insuficiente para producto id %s".formatted(item.productId()));
            }

            product.setStock(product.getStock() - item.quantity());
            repository.save(product);
        }
    }

    @Transactional
    public void restockProduct(List<ProductQuantityRequest> request) {
        for (ProductQuantityRequest item : request) {
            Product product = repository.findById(item.productId())
                    .orElseThrow(() -> new ProductException("Producto con id %s no encontrado".formatted(item.productId())));

            if (item.quantity() < 0) {
                throw new ProductException("Cantidad de restock no puede ser negativa para producto de id %s".formatted(item.productId()));
            }

            product.setStock(product.getStock() + item.quantity());
            repository.save(product);
        }
    }

}
