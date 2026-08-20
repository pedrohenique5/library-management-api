package com.pedrohenrique.library_management_api.core.application.contracts.repositories;

import com.pedrohenrique.library_management_api.core.domain.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    Address save(Address address);
    Optional<Address> findById(Long id);
    List <Address> findAll();
    void delete(Long id);

    }

