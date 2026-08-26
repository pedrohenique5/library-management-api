package com.pedrohenrique.library_management_api.core.application.dtos.author.request;

import java.time.LocalDate;

public record AuthorRequestDTO (Long id,String name,String nationality,LocalDate birthDate){}

