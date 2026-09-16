package com.pedrohenrique.library_management_api.core.application.exceptions;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException() {
        super("Editora não encontrada");
    }
}
