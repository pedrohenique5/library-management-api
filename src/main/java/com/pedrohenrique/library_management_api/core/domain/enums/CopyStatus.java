package com.pedrohenrique.library_management_api.core.domain.enums;

public enum CopyStatus {
    AVAILABLE("Disponível"),
    BORROWED("Emprestado"),
    RESERVED("Reservado"),
    DAMAGED("Danificado"),
    LOST("Perdido"),
    UNDER_MAINTENANCE("Em manutenção");

    private final String description;

    CopyStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
