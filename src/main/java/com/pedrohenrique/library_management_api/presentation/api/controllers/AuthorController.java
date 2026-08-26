package com.pedrohenrique.library_management_api.presentation.api.controllers;

import com.pedrohenrique.library_management_api.core.application.dtos.author.request.AuthorRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.author.response.AuthorResponseDTO;
import com.pedrohenrique.library_management_api.core.application.usecases.author.*;
import com.pedrohenrique.library_management_api.core.domain.entities.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final CreateAuthorUseCase createAuthorUseCase;
    private final FindAuthorByIdUseCase findAuthorByIdUseCase;
    private final ListAuthorsUseCase listAuthorsUseCase;
    private final UpdateAuthorUseCase updateAuthorUseCase;
    private final DeleteAuthorUseCase deleteAuthorUseCase;

    public AuthorController(CreateAuthorUseCase createAuthorUseCase,
                            FindAuthorByIdUseCase findAuthorByIdUseCase,
                            ListAuthorsUseCase listAuthorsUseCase,
                            UpdateAuthorUseCase updateAuthorUseCase,
                            DeleteAuthorUseCase deleteAuthorUseCase
                            ){
        this.createAuthorUseCase = createAuthorUseCase;
        this.findAuthorByIdUseCase = findAuthorByIdUseCase;
        this.listAuthorsUseCase = listAuthorsUseCase;
        this.updateAuthorUseCase = updateAuthorUseCase;
        this.deleteAuthorUseCase = deleteAuthorUseCase;

    }

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> create(@RequestBody AuthorRequestDTO dto) {
        Author created = createAuthorUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDTO(findAuthorByIdUseCase.execute(id)));

    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> findAll() {
        return ResponseEntity.ok(
                listAuthorsUseCase.execute().stream().map(this::toResponseDTO).collect(Collectors.toList())
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> update(@PathVariable Long id, @RequestBody AuthorRequestDTO dto) {
        return ResponseEntity.ok(toResponseDTO(updateAuthorUseCase.execute(id, dto)));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteAuthorUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    private AuthorResponseDTO toResponseDTO(Author author) {
        return new AuthorResponseDTO(
                author.getId(), author.getName(), author.getNationality(), author.getBirthDate());
    }
}
