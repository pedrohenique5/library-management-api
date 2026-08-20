package com.pedrohenrique.library_management_api.core.application.dtos;

public record AddressResponseDTO(
        Long id, String street, String number, String complement,
        String neighborhood, String city, String state, String zipCode
) {
}
