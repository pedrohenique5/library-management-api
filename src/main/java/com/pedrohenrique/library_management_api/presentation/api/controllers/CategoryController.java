package com.pedrohenrique.library_management_api.presentation.api.controllers;

import com.pedrohenrique.library_management_api.core.application.dtos.category.request.CategoryRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.category.response.CategoryResponseDTO;
import com.pedrohenrique.library_management_api.core.application.usecases.category.*;
import com.pedrohenrique.library_management_api.core.domain.entities.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final FindCategoryByIdUseCase findCategoryByIdUseCase;
    private final ListCategoriesUseCase listCategoriesUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;

    public CategoryController(
            CreateCategoryUseCase createCategoryUseCase,
            FindCategoryByIdUseCase findCategoryByIdUseCase,
            ListCategoriesUseCase listCategoriesUseCase,
            UpdateCategoryUseCase updateCategoryUseCase,
            DeleteCategoryUseCase deleteCategoryUseCase
    ){

        this.createCategoryUseCase = createCategoryUseCase;
        this.findCategoryByIdUseCase = findCategoryByIdUseCase;
        this.listCategoriesUseCase = listCategoriesUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;

    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody CategoryRequestDTO dto) {
        Category created = createCategoryUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(created));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDTO(findCategoryByIdUseCase.execute(id)));

    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        return ResponseEntity.ok(
            listCategoriesUseCase.execute().stream().map(this::toResponseDTO).collect(Collectors.toList()));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @RequestBody CategoryRequestDTO dto) {
        return ResponseEntity.ok(toResponseDTO(updateCategoryUseCase.execute(id, dto)));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteCategoryUseCase.execute(id);
        return ResponseEntity.noContent().build();

    }

    private CategoryResponseDTO toResponseDTO(Category category) {
        return new CategoryResponseDTO(
            category.getId(), category.getName(), category.getDescription());
    }
}
