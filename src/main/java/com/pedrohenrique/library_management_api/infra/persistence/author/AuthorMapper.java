package com.pedrohenrique.library_management_api.infra.persistence.author;

import com.pedrohenrique.library_management_api.core.domain.entities.Author;

public class AuthorMapper {
    public  static Author toDomain(AuthorJpaEntity jpa){
        return new Author(
                jpa.getId(), jpa.getName(), jpa.getNationality(), jpa.getBirthDate()
        );

    }

    public static AuthorJpaEntity toJpaEntity(Author domain){
        return new AuthorJpaEntity(
                domain.getId(), domain.getName(), domain.getNationality(), domain.getBirthDate()
        );
    }
}
