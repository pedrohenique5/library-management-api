package com.pedrohenrique.library_management_api.core.application.usecases.author;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AuthorRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAuthorsUseCase {
    public final AuthorRepository authorRepository;
    public ListAuthorsUseCase(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> execute() {
        return authorRepository.findAll();
    }
}
