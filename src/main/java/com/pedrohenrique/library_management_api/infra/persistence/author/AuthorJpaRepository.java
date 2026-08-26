package com.pedrohenrique.library_management_api.infra.persistence.author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorJpaRepository extends JpaRepository<AuthorJpaEntity, Long> {
}
