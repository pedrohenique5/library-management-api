package com.pedrohenrique.library_management_api.infra.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository <UserJpaEntity, Long> {
    Optional<UserJpaEntity> findByEmail(String email);
    Boolean existsByCpf(String cpf);
    Boolean existsByEmail(String email);
}
