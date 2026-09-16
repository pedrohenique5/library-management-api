package com.pedrohenrique.library_management_api.presentation.api.controllers;

import com.pedrohenrique.library_management_api.core.application.dtos.publisher.request.PublisherRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.publisher.response.PublisherResponseDTO;
import com.pedrohenrique.library_management_api.core.application.usecases.publisher.*;
import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final CreatePublisherUseCase createPublisherUseCase;
    private final FindPublisherByIdUseCase findPublisherByIdUseCase;
    private final ListPublishersUseCase listPublishersUseCase;
    private final UpdatePublisherUseCase updatePublisherUseCase;
    private final DeletePublisherUseCase deletePublisherUseCase;

    public PublisherController(
            CreatePublisherUseCase createPublisherUseCase,
            FindPublisherByIdUseCase findPublisherByIdUseCase,
            ListPublishersUseCase listPublishersUseCase,
            UpdatePublisherUseCase updatePublisherUseCase,
            DeletePublisherUseCase deletePublisherUseCase
    ){
        this.createPublisherUseCase = createPublisherUseCase;
        this.findPublisherByIdUseCase = findPublisherByIdUseCase;
        this.listPublishersUseCase = listPublishersUseCase;
        this.updatePublisherUseCase = updatePublisherUseCase;
        this.deletePublisherUseCase = deletePublisherUseCase;

    }

    @PostMapping
    public ResponseEntity<PublisherResponseDTO> create(@RequestBody PublisherRequestDTO dto) {
        Publisher created = createPublisherUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(created));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDTO(findPublisherByIdUseCase.execute(id)));

    }

    @GetMapping
    public ResponseEntity<List<PublisherResponseDTO>> findAll() {
        return ResponseEntity.ok(
            listPublishersUseCase.execute().stream().map(this::toResponseDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDTO> update(@PathVariable Long id, @RequestBody PublisherRequestDTO dto) {
        return ResponseEntity.ok(toResponseDTO(updatePublisherUseCase.execute(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePublisherUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    private PublisherResponseDTO toResponseDTO(Publisher publisher) {
        return new PublisherResponseDTO(
            publisher.getId(), publisher.getName(), publisher.getCnpj(), publisher.getPhone());
    }
}
