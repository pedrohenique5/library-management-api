package com.pedrohenrique.library_management_api.core.application.dtos.publisher.request;

public record PublisherRequestDTO(
        String name, String cnpj, String phone
) {
}
