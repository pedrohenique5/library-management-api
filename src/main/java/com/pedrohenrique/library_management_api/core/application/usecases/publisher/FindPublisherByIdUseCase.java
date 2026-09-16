package com.pedrohenrique.library_management_api.core.application.usecases.publisher;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.PublisherRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.PublisherNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;
import org.springframework.stereotype.Component;

@Component
public class FindPublisherByIdUseCase {
    private final PublisherRepository publisherRepository;
    public FindPublisherByIdUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;

    }

    public Publisher execute(Long id){
        return publisherRepository.findById(id).orElseThrow(PublisherNotFoundException::new);
    }
}
