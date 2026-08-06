package com.pedrohenrique.library_management_api.infra.persistence;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.UserRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl  implements UserRepository {

    public final UserJpaRepository jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public User save(User user) {
        UserJpaEntity jpaEntity = UserMapper.toJpaEntity(user);
        UserJpaEntity saved = jpaRepository.save(jpaEntity);
        return UserMapper.toDomain(saved);

    }

    @Override
    public Optional<User> findById(Long id){
        return jpaRepository.findById(id).map(UserMapper::toDomain);

    }

    @Override
    public Optional<User> findByEmail(String email){
        return jpaRepository.findByEmail(email).map(UserMapper::toDomain);

    }

    @Override
    public Boolean existsByCpf(String cpf){
        return  jpaRepository.existsByCpf(cpf);

    }

    @Override
    public Boolean existsByEmail(String email){
        return jpaRepository.existsByEmail(email);

    }

    @Override
    public List<User> findAll(){
        return jpaRepository.findAll().stream().map(UserMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        jpaRepository.deleteById(id);
    }

}
