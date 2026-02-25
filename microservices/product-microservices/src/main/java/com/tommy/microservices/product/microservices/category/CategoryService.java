package com.tommy.microservices.product.microservices.category;

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
}
