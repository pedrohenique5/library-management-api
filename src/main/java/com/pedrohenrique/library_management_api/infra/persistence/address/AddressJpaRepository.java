package com.pedrohenrique.library_management_api.infra.persistence.address;

import com.pedrohenrique.library_management_api.core.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJpaRepository extends JpaRepository<AddressJpaEntity, Long> {

}
