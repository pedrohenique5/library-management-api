package com.pedrohenrique.library_management_api.core.application.exceptions;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException() {
        super("Perfil não encontrado");
    }
}
