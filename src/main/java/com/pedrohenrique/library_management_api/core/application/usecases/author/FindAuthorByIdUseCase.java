package com.pedrohenrique.library_management_api.core.application.usecases.author;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AuthorRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.AuthorNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class FindAuthorByIdUseCase {

    public final AuthorRepository authorRepository;
    public FindAuthorByIdUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author execute(Long id) {
        return authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

}