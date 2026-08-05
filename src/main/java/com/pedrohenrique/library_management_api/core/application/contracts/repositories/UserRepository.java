package com.pedrohenrique.library_management_api.core.application.contracts.repositories;

import com.pedrohenrique.library_management_api.core.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String Email);
    Boolean existsByCpf(String cpf);
    Boolean existsByEmail(String email);
    List<User>findAll();
    void delete(User user);
}
