package com.pedrohenrique.library_management_api.infra.persistence.category;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.CategoryRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository jpaRepository;

    public CategoryRepositoryImpl(CategoryJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;

    }

    @Override
    public Category save(Category category){
        CategoryJpaEntity jpa = CategoryMapper.toJpaEntity(category);
        CategoryJpaEntity saved = jpaRepository.save(jpa);
        return CategoryMapper.toDomain(saved);

    }

    @Override
    public Optional<Category>findById(Long id){
        return jpaRepository.findById(id).map(CategoryMapper::toDomain);

    }

    @Override
    public List<Category> findAll(){
        return jpaRepository.findAll().stream().map(CategoryMapper::toDomain).collect(Collectors.toList());

    }

    @Override
    public  void  delete(Long id){
        jpaRepository.deleteById(id);
    }
}
