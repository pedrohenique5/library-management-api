package com.pedrohenrique.library_management_api.core.application.usecases.address;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AddressRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAddressesUseCase {
    private final AddressRepository addressRepository;
    public ListAddressesUseCase(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;

    }

    public List<Address> execute() {
        return addressRepository.findAll();
    }
}

