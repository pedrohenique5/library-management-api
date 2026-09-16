package com.pedrohenrique.library_management_api.core.application.dtos.publisher.response;

public record PublisherResponseDTO(
        Long id, String name, String cnpj, String phone
) {
}
