package com.pedrohenrique.library_management_api.infra.persistence.profile;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ProfileRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProfileRepositoryImpl  implements ProfileRepository {

    private final ProfileJpaRepository jpaRepository;

    public ProfileRepositoryImpl(ProfileJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;

    }

    @Override
    public Profile save(Profile profile){
        ProfileJpaEntity jpa = ProfileMapper.toJpaEntity(profile);
        ProfileJpaEntity saved = jpaRepository.save(jpa);
        return ProfileMapper.toDomain(saved);

    }

    @Override
    public Optional<Profile> findById(Long id){
        return jpaRepository.findById(id).map(ProfileMapper::toDomain);

    }

    @Override
    public List<Profile> findAll(){
        return jpaRepository.findAll().stream().map(ProfileMapper::toDomain).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id){
        jpaRepository.deleteById(id);
    }


}
