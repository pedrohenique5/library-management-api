package com.pedrohenrique.library_management_api.presentation.api.controllers;

import com.pedrohenrique.library_management_api.core.application.dtos.returnrule.request.ReturnRuleRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.returnrule.response.ReturnRuleResponseDTO;
import com.pedrohenrique.library_management_api.core.application.usecases.returnrule.*;
import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/return-rules")
public class ReturnRuleController {

    private final CreateReturnRuleUseCase createReturnRuleUseCase;
    private final FindReturnRuleByIdUseCase findReturnRuleByIdUseCase;
    private final ListReturnRulesUseCase listReturnRulesUseCase;
    private final UpdateReturnRuleUseCase updateReturnRuleUseCase;
    private final DeleteReturnRuleUseCase deleteReturnRuleUseCase;

    public ReturnRuleController(
            CreateReturnRuleUseCase createReturnRuleUseCase,
            FindReturnRuleByIdUseCase findReturnRuleByIdUseCase,
            ListReturnRulesUseCase listReturnRulesUseCase,
            UpdateReturnRuleUseCase updateReturnRuleUseCase,
            DeleteReturnRuleUseCase deleteReturnRuleUseCase
    ){
        this.createReturnRuleUseCase = createReturnRuleUseCase;
        this.findReturnRuleByIdUseCase = findReturnRuleByIdUseCase;
        this.listReturnRulesUseCase = listReturnRulesUseCase;
        this.updateReturnRuleUseCase = updateReturnRuleUseCase;
        this.deleteReturnRuleUseCase = deleteReturnRuleUseCase;

    }

    @PostMapping
    public ResponseEntity<ReturnRuleResponseDTO> create(@RequestBody ReturnRuleRequestDTO dto) {
        ReturnRule created = createReturnRuleUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(created));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnRuleResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDTO(findReturnRuleByIdUseCase.execute(id)));

    }

    @GetMapping
    public ResponseEntity<List<ReturnRuleResponseDTO>> findAll() {
        return ResponseEntity.ok(
            listReturnRulesUseCase.execute().stream().map(this::toResponseDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReturnRuleResponseDTO> update(@PathVariable Long id, @RequestBody ReturnRuleRequestDTO dto) {
        return ResponseEntity.ok(toResponseDTO(updateReturnRuleUseCase.execute(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteReturnRuleUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    private ReturnRuleResponseDTO toResponseDTO(ReturnRule returnRule) {
        return new ReturnRuleResponseDTO(
            returnRule.getId(), returnRule.getFinePerDayLate());
    }
}
