package com.pedrohenrique.library_management_api.core.domain.enums;

public enum Role {
    CUSTOMER("Cliente"),
    EMPLOYEE("Funcionário"),
    ADMIN("Administrador");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
