package com.pedrohenrique.library_management_api.core.application.usecases.publisher;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.PublisherRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.publisher.request.PublisherRequestDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;
import org.springframework.stereotype.Component;

@Component
public class CreatePublisherUseCase {
    private final PublisherRepository publisherRepository;

    public CreatePublisherUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher execute(PublisherRequestDTO dto){
        Publisher publisher = new Publisher(null, dto.name(), dto.cnpj(), dto.phone());
        return publisherRepository.save(publisher);
    }
}
