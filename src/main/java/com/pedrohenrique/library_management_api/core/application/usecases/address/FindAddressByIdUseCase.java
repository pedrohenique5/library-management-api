package com.pedrohenrique.library_management_api.core.application.usecases.address;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AddressRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.AddressNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByIdUseCase {
    private final AddressRepository addressRepository;
    public FindAddressByIdUseCase(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;

    }

    public Address execute(Long id) {
        return addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
    }
}
