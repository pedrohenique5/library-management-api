package com.pedrohenrique.library_management_api.core.application.usecases.category;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.CategoryRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.category.request.CategoryRequestDTO;
import com.pedrohenrique.library_management_api.core.application.exceptions.CategoryNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryUseCase {
    private final CategoryRepository categoryRepository;
    public UpdateCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }
    public Category execute(Long id, CategoryRequestDTO dto) {
        Category existing = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        existing.setName(dto.name());
        existing.setDescription(dto.description());
        return categoryRepository.save(existing);
    }
}
