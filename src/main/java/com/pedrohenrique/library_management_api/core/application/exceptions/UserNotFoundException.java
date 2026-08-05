package com.pedrohenrique.library_management_api.core.application.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("Usuário não encontrado");
    }
}
