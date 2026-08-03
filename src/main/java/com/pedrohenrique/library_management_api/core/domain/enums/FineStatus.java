package com.pedrohenrique.library_management_api.core.domain.enums;

public enum FineStatus {
    PENDING("Pendente"),
    PAID("Paga"),
    WAIVED("Isenta");

    private final String description;

    FineStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}