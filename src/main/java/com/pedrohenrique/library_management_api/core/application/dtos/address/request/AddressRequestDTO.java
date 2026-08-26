package com.pedrohenrique.library_management_api.core.application.dtos.address.request;

public record AddressRequestDTO(
        String street, String number, String complement,
        String neighborhood, String city, String state, String zipCode) {
}
