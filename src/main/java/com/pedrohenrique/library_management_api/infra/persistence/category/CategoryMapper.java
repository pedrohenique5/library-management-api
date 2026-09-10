package com.pedrohenrique.library_management_api.infra.persistence.category;


import com.pedrohenrique.library_management_api.core.domain.entities.Category;

public class CategoryMapper {

    public static Category toDomain(CategoryJpaEntity jpa){
        return new Category(jpa.getId(), jpa.getName(), jpa.getDescription());

    }

    public static CategoryJpaEntity toJpaEntity(Category domain){
        return new CategoryJpaEntity(domain.getId(), domain.getName(), domain.getDescription());
    }
}
