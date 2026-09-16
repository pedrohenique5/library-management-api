package com.pedrohenrique.library_management_api.infra.persistence.publisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherJpaRepository extends JpaRepository<PublisherJpaEntity, Long> {
}
