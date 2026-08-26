package com.pedrohenrique.library_management_api.core.application.dtos.user.request;

public record LoginRequestDTO(

        String email,
        String password
) {
}
