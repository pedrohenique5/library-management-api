package com.pedrohenrique.library_management_api.infra.persistence.author;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.AuthorRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AuthorRepositoryImpl  implements AuthorRepository {

    private final AuthorJpaRepository jpaRepository;

    public AuthorRepositoryImpl(AuthorJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Author save(Author author){
        AuthorJpaEntity jpaEntity = AuthorMapper.toJpaEntity(author);
        AuthorJpaEntity saved = jpaRepository.save(jpaEntity);
        return AuthorMapper.toDomain(saved);

    }

    @Override
    public Optional <Author> findById(Long id){
        return jpaRepository.findById(id).map(AuthorMapper::toDomain);

    }

    @Override
    public List <Author> findAll(){
        return jpaRepository.findAll().stream().map(AuthorMapper::toDomain).collect(Collectors.toList());

    }

    @Override
    public void  delete(Long id){
        jpaRepository.deleteById(id);
    }

}
