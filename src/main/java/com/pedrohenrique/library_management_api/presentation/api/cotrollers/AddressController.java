package com.pedrohenrique.library_management_api.presentation.api.cotrollers;

import com.pedrohenrique.library_management_api.core.application.contracts.usecases.*;
import com.pedrohenrique.library_management_api.core.application.dtos.AddressRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.AddressResponseDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressUseCase AddressUseCase;
    private final FindAddressByIdUseCase findAddressByIdUseCase;
    private final ListAddressesUseCase listAddressesUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;
    private final DeleteAddressUseCase deleteAddressUseCase;

    public AddressController(AddressUseCase AddressUseCase,
                             FindAddressByIdUseCase findAddressByIdUseCase,
                             ListAddressesUseCase listAddressesUseCase,
                             UpdateAddressUseCase updateAddressUseCase,
                             DeleteAddressUseCase deleteAddressUseCase) {
        this.AddressUseCase = AddressUseCase;
        this.findAddressByIdUseCase = findAddressByIdUseCase;
        this.listAddressesUseCase = listAddressesUseCase;
        this.updateAddressUseCase = updateAddressUseCase;
        this.deleteAddressUseCase = deleteAddressUseCase;

    }


    @PostMapping
    public ResponseEntity<AddressResponseDTO> create(@RequestBody AddressRequestDTO dto) {
        Address created = AddressUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDTO(findAddressByIdUseCase.execute(id)));
    }

    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> findAll() {
        return ResponseEntity.ok(
                listAddressesUseCase.execute().stream().map(this::toResponseDTO).collect(Collectors.toList())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> update(@PathVariable Long id, @RequestBody AddressRequestDTO dto) {
        return ResponseEntity.ok(toResponseDTO(updateAddressUseCase.execute(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteAddressUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    private AddressResponseDTO toResponseDTO(Address address) {
        return new AddressResponseDTO(
                address.getId(), address.getStreet(), address.getNumber(), address.getComplement(),
                address.getNeighborhood(), address.getCity(), address.getState(), address.getZipCode()
        );
    }

}
