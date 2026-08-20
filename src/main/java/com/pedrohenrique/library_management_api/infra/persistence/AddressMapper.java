package com.pedrohenrique.library_management_api.infra.persistence;

import com.pedrohenrique.library_management_api.core.domain.entities.Address;

public class AddressMapper {

    public static Address toDomain(AddressJpaEntity jpa) {
        return new Address(
                jpa.getId(), jpa.getStreet(), jpa.getNumber(), jpa.getComplement(),
                jpa.getNeighborhood(), jpa.getCity(), jpa.getState(), jpa.getZipCode()
        );
    }

    public static AddressJpaEntity toJpaEntity(Address domain) {
        return new AddressJpaEntity(
                domain.getId(), domain.getStreet(), domain.getNumber(), domain.getComplement(),
                domain.getNeighborhood(), domain.getCity(), domain.getState(), domain.getZipCode()
        );
    }
}

