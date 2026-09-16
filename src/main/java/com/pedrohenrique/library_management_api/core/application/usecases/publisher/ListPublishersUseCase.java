package com.pedrohenrique.library_management_api.core.application.usecases.publisher;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.PublisherRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListPublishersUseCase {
    private final PublisherRepository publisherRepository;
    public ListPublishersUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;

    }

    public List<Publisher> execute() {
        return publisherRepository.findAll();
    }
}
