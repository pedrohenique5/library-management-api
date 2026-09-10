package com.pedrohenrique.library_management_api.core.application.usecases.category;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.CategoryRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.CategoryNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class FindCategoryByIdUseCase {
    private final CategoryRepository categoryRepository;
    public FindCategoryByIdUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(Long id) {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }
}
