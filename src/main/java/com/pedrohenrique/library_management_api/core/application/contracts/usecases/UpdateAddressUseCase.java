package com.pedrohenrique.library_management_api.core.application.contracts.usecases;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AddressRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.AddressRequestDTO;
import com.pedrohenrique.library_management_api.core.application.exceptions.AddressNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class UpdateAddressUseCase {
    private final AddressRepository addressRepository;
    public UpdateAddressUseCase(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;

    }

    public Address execute(Long id, AddressRequestDTO dto) {
        Address existing = addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
        existing.setStreet(dto.street());
        existing.setNumber(dto.number());
        existing.setComplement(dto.complement());
        existing.setNeighborhood(dto.neighborhood());
        existing.setCity(dto.city());
        existing.setState(dto.state());
        existing.setZipCode(dto.zipCode());
        return addressRepository.save(existing);
    }
}

