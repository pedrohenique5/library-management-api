package com.pedrohenrique.library_management_api.core.application.usecases.category;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.CategoryRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.category.request.CategoryRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.category.response.CategoryResponseDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;
    public CreateCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(CategoryRequestDTO dto) {
        Category category = new Category(null, dto.name(), dto.description());
        return categoryRepository.save(category);
    }
}
