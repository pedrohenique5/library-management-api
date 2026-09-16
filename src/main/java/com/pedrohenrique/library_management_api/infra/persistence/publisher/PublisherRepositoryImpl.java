package com.pedrohenrique.library_management_api.infra.persistence.publisher;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.PublisherRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.Publisher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PublisherRepositoryImpl  implements PublisherRepository {

    private final PublisherJpaRepository jpaRepository;

    public PublisherRepositoryImpl(PublisherJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;

    }

    @Override
    public Publisher save(Publisher publisher){
        PublisherJpaEntity jpa = PublisherMapper.toJpaEntity(publisher);
        PublisherJpaEntity saved = jpaRepository.save(jpa);
        return PublisherMapper.toDomain(saved);

    }

    @Override
    public Optional<Publisher> findById(Long id){
        return jpaRepository.findById(id).map(PublisherMapper::toDomain);

    }

    @Override
    public List<Publisher> findAll(){
        return jpaRepository.findAll().stream().map(PublisherMapper::toDomain).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id){
        jpaRepository.deleteById(id);
    }


}
