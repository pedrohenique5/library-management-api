package com.pedrohenrique.library_management_api.core.domain.enums;

public enum LoanStatus {
    ACTIVE("Ativo"),
    RETURNED("Devolvido"),
    LATE("Atrasado"),
    NOT_RETURNED("Não devolvido");

    private final String description;

    LoanStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}