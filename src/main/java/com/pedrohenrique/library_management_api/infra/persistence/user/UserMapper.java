package com.pedrohenrique.library_management_api.infra.persistence.user;

import com.pedrohenrique.library_management_api.core.domain.entities.User;

public class UserMapper {

    public static User toDomain(UserJpaEntity jpa){
        return new User(
                jpa.getId(), jpa.getName(), jpa.getCpf(), jpa.getPhone(), jpa.getPassword(), jpa.getEmail(),
                jpa.getBirthDate(), jpa.getRegistrationDate(), jpa.getActive(),
                jpa.getAddressId(), jpa.getRole(), jpa.getProfileId(), jpa.getCustomLoanLimit()
        );
    }

    public static UserJpaEntity toJpaEntity(User domain){
        return new UserJpaEntity(
                domain.getId(), domain.getName(), domain.getCpf(), domain.getPhone(), domain.getPassword(), domain.getEmail(),
                domain.getBirthDate(), domain.getRegistrationDate(), domain.isActive(),
                domain.getAddressId(), domain.getRole(), domain.getProfileId(), domain.getCustomLoanLimit()
        );
    }
}
