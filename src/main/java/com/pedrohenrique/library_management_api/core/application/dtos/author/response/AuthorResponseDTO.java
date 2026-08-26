package com.pedrohenrique.library_management_api.core.application.dtos.author.response;

import java.time.LocalDate;

public record AuthorResponseDTO(Long id, String name, String nationality, LocalDate birthDate) {
}
