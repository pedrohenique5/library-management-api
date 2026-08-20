package com.pedrohenrique.library_management_api.core.application.dtos;

public record AddressRequestDTO(
        String street, String number, String complement,
        String neighborhood, String city, String state, String zipCode) {
}
