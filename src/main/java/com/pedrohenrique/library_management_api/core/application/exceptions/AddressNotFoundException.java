package com.pedrohenrique.library_management_api.core.application.exceptions;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException() {
    super("endereço não encontrado");
    }
}
