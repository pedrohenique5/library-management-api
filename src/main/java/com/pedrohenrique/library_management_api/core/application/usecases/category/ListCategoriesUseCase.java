package com.pedrohenrique.library_management_api.core.application.usecases.category;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.CategoryRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListCategoriesUseCase {
    private final CategoryRepository categoryRepository;
    public ListCategoriesUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
