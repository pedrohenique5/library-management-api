package com.pedrohenrique.library_management_api.core.application.usecases.publisher;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.PublisherRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.publisher.request.PublisherRequestDTO;
import com.pedrohenrique.library_management_api.core.application.exceptions.PublisherNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;
import org.springframework.stereotype.Component;

@Component
public class UpdatePublisherUseCase {
    private final PublisherRepository publisherRepository;
    public UpdatePublisherUseCase(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;

    }

    public Publisher execute(Long id, PublisherRequestDTO dto){
        Publisher existing = publisherRepository.findById(id).orElseThrow(PublisherNotFoundException::new);
        existing.setName(dto.name());
        existing.setCnpj(dto.cnpj());
        existing.setPhone(dto.phone());
        return publisherRepository.save(existing);
    }
}
