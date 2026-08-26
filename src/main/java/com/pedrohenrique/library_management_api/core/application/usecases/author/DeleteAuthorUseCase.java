package com.pedrohenrique.library_management_api.core.application.usecases.author;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AuthorRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.AuthorNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeleteAuthorUseCase {
    public final AuthorRepository authorRepository;
    public DeleteAuthorUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void execute(Long id) {
        authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
        authorRepository.delete(id);
    }
}
