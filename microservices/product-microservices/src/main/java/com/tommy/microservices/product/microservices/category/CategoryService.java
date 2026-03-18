package com.tommy.microservices.product.microservices.category;

import com.tommy.microservices.product.microservices.exceptions.CategoryException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;


    public List<CategoryResponse> getAllCategories() {
        return repository.findAll().stream()
                .map(mapper::toCategoryResponse)
                .toList();
    }

    public Integer createCategory(@Valid CategoryRequest request) {
        Category category = mapper.toCategory(request);
        return repository.save(category).getId();
    }
    public void deleteCategory(Integer id) {
        if (id == null ) {
            throw new CategoryException("Id de categoría no puede estar vacío o ser nulo.");
        }
        else if (!repository.existsById(id)) {
            throw new CategoryException("Categoria con id id %s no encontrada.".formatted(id));
        }
        repository.deleteById(id);
    }

    public Integer updateCategory(CategoryRequest request) {
        Category category = mapper.toCategory(request);
        if (request.id() == null) {
            throw new CategoryException("Id de categoría no puede ser nula.");
        }
        else if (!repository.existsById(request.id())) {
            throw new CategoryException("Categoria con ID %s no encontrada".formatted(request.id()));
        }
        repository.save(category);
        return category.getId();
    }

    public CategoryResponse getCategoryById(Integer id) {
        return repository
                .findById(id)
                .map(mapper::toCategoryResponse)
                .orElseThrow(() -> new CategoryException("Categoria con Id %s no encontrada".formatted(id)));
    }
}
