package com.pedrohenrique.library_management_api.presentation.api.controllers;

import com.pedrohenrique.library_management_api.core.application.dtos.profile.request.ProfileRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.profile.response.ProfileResponseDTO;
import com.pedrohenrique.library_management_api.core.application.usecases.profile.*;
import com.pedrohenrique.library_management_api.core.domain.entities.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final CreateProfileUseCase createProfileUseCase;
    private final FindProfileByIdUseCase findProfileByIdUseCase;
    private final ListProfilesUseCase listProfilesUseCase;
    private final UpdateProfileUseCase updateProfileUseCase;
    private final DeleteProfileUseCase deleteProfileUseCase;

    public ProfileController(
            CreateProfileUseCase createProfileUseCase,
            FindProfileByIdUseCase findProfileByIdUseCase,
            ListProfilesUseCase listProfilesUseCase,
            UpdateProfileUseCase updateProfileUseCase,
            DeleteProfileUseCase deleteProfileUseCase
    ){
        this.createProfileUseCase = createProfileUseCase;
        this.findProfileByIdUseCase = findProfileByIdUseCase;
        this.listProfilesUseCase = listProfilesUseCase;
        this.updateProfileUseCase = updateProfileUseCase;
        this.deleteProfileUseCase = deleteProfileUseCase;

    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> create(@RequestBody ProfileRequestDTO dto) {
        Profile created = createProfileUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(created));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDTO(findProfileByIdUseCase.execute(id)));

    }

    @GetMapping
    public ResponseEntity<List<ProfileResponseDTO>> findAll() {
        return ResponseEntity.ok(
            listProfilesUseCase.execute().stream().map(this::toResponseDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> update(@PathVariable Long id, @RequestBody ProfileRequestDTO dto) {
        return ResponseEntity.ok(toResponseDTO(updateProfileUseCase.execute(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteProfileUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    private ProfileResponseDTO toResponseDTO(Profile profile) {
        return new ProfileResponseDTO(
            profile.getId(), profile.getName(), profile.getLoanLimit(), profile.getLoanPeriodDays());
    }
}
