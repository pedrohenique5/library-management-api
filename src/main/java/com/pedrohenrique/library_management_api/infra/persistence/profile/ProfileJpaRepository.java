package com.pedrohenrique.library_management_api.infra.persistence.profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileJpaRepository extends JpaRepository<ProfileJpaEntity, Long> {
}
