package com.pedrohenrique.library_management_api.core.application.contracts.repositories;

import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository {
    Publisher save(Publisher publisher);
    Optional<Publisher> findById(Long id);
    List<Publisher> findAll();
    void delete(Long id);
}
