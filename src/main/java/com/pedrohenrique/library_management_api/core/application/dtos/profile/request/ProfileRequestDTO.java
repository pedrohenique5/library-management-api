package com.pedrohenrique.library_management_api.core.application.dtos.profile.request;

public record ProfileRequestDTO(
        String name, Integer loanLimit, Integer loanPeriodDays
) {
}
