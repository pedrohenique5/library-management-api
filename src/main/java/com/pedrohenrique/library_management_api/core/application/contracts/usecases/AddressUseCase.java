package com.pedrohenrique.library_management_api.core.application.contracts.usecases;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AddressRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.AddressRequestDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressUseCase {
    private final AddressRepository addressRepository;
    public AddressUseCase(AddressRepository addressRepository){
        this.addressRepository = addressRepository;

    }

    public Address execute(AddressRequestDTO dto){
        Address address = new Address(null, dto.street(), dto.number(), dto.complement(),
                dto.neighborhood(), dto.city(), dto.state(), dto.zipCode());
        return addressRepository.save(address);
    }


}
