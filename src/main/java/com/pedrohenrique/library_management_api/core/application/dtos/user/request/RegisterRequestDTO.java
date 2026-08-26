package com.pedrohenrique.library_management_api.core.application.dtos.user.request;

import com.pedrohenrique.library_management_api.core.domain.enums.Role;

import java.time.LocalDate;

public record RegisterRequestDTO (

    String name,
    String cpf,
    String phone,
    String password,
    String email,
    LocalDate birthDate,
    Long addressId,
    Role role,
    Long profileId,
    Integer customLoanLimit
    ) {
}
