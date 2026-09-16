package com.pedrohenrique.library_management_api.core.application.usecases.publisher;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.PublisherRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.PublisherNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeletePublisherUseCase {
    private final PublisherRepository publisherRepository;
    public DeletePublisherUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;

    }

    public void execute(Long id) {
        publisherRepository.findById(id).orElseThrow(PublisherNotFoundException::new);
        publisherRepository.delete(id);
    }
}
