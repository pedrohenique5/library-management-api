package com.pedrohenrique.library_management_api.core.application.usecases.author;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AuthorRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.author.request.AuthorRequestDTO;
import com.pedrohenrique.library_management_api.core.application.exceptions.AuthorNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class UpdateAuthorUseCase {
    public final AuthorRepository authorRepository;
    public UpdateAuthorUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author execute(Long id, AuthorRequestDTO dto) {
        Author  existing = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        existing.setName(dto.name());
        existing.setNationality(dto.nationality());
        existing.setBirthDate(dto.birthDate());
        return authorRepository.save(existing);

    }
}
