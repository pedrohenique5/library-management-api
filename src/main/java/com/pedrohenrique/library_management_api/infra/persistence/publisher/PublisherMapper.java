package com.pedrohenrique.library_management_api.infra.persistence.publisher;

import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;

public class PublisherMapper {

    public static Publisher toDomain(PublisherJpaEntity jpa){
        return new Publisher(jpa.getId(), jpa.getName(), jpa.getCnpj(), jpa.getPhone());
    }

    public static PublisherJpaEntity toJpaEntity(Publisher domain){
        return new PublisherJpaEntity(domain.getId(), domain.getName(), domain.getCnpj(), domain.getPhone());
    }
}
