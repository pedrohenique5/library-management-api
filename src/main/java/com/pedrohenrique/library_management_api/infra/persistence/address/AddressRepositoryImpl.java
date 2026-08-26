package com.pedrohenrique.library_management_api.infra.persistence.address;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AddressRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Address;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressJpaRepository jpaRepository;

    public AddressRepositoryImpl(AddressJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;

    }

    @Override
    public Address save(Address address) {
        AddressJpaEntity jpaEntity = AddressMapper.toJpaEntity(address);
        AddressJpaEntity saved = jpaRepository.save(jpaEntity);
        return AddressMapper.toDomain(saved);

    }

    @Override
    public Optional<Address> findById(Long id) {
        return jpaRepository.findById(id).map(AddressMapper::toDomain);

    }

    @Override
    public List<Address> findAll() {
        return jpaRepository.findAll().stream().map(AddressMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}