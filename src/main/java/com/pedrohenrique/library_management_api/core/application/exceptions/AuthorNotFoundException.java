package com.pedrohenrique.library_management_api.core.application.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException() {
        super("Autor não encontrado");
    }
}
