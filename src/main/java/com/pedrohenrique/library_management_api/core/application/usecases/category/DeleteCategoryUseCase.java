package com.pedrohenrique.library_management_api.core.application.usecases.category;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.CategoryRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.CategoryNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryUseCase {
    private final CategoryRepository categoryRepository;
    public DeleteCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void execute(Long id) {
        categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(id);
    }
}
