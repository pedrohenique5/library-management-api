package com.pedrohenrique.library_management_api.core.application.usecases.author;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AuthorRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.author.request.AuthorRequestDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorUseCase {
    private final AuthorRepository authorRepository;
    public CreateAuthorUseCase(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author execute(AuthorRequestDTO dto){
        Author author = new Author(null, dto.name(), dto.nationality(),dto.birthDate());
        return authorRepository.save(author);
    }
}
