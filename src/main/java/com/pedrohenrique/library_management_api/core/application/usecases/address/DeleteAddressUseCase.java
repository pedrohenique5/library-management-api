package com.pedrohenrique.library_management_api.core.application.usecases.address;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AddressRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.AddressNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeleteAddressUseCase {
    private final AddressRepository addressRepository;
    public DeleteAddressUseCase(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void execute(Long id) {
        addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
        addressRepository.delete(id);
    }
}
