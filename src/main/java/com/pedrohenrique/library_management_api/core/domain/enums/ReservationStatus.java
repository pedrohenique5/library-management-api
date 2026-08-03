package com.pedrohenrique.library_management_api.core.domain.enums;

public enum ReservationStatus {
    WAITING("Aguardando"),
    AVAILABLE("Disponível"),
    FULFILLED("Atendida"),
    CANCELED("Cancelada"),
    EXPIRED("Expirada");

    private final String description;

    ReservationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}