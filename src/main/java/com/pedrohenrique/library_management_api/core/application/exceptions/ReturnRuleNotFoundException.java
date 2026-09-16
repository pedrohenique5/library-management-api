package com.pedrohenrique.library_management_api.core.application.exceptions;

public class ReturnRuleNotFoundException extends RuntimeException {
    public ReturnRuleNotFoundException() {
        super("Regra de devolução não encontrada");
    }
}
