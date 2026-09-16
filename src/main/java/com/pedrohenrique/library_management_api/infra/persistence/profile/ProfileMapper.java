package com.pedrohenrique.library_management_api.infra.persistence.profile;

import com.pedrohenrique.library_management_api.core.domain.entities.Profile;

public class ProfileMapper {

    public static Profile toDomain(ProfileJpaEntity jpa){
        return new Profile(jpa.getId(), jpa.getName(), jpa.getLoanLimit(), jpa.getLoanPeriodDays());
    }

    public static ProfileJpaEntity toJpaEntity(Profile domain){
        return new ProfileJpaEntity(domain.getId(), domain.getName(), domain.getLoanLimit(), domain.getLoanPeriodDays());
    }
}
