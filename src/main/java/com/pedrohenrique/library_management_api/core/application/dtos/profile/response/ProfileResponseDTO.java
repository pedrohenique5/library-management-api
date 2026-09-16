package com.pedrohenrique.library_management_api.core.application.dtos.profile.response;

public record ProfileResponseDTO(
        Long id, String name, Integer loanLimit, Integer loanPeriodDays
) {
}
