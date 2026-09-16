package com.pedrohenrique.library_management_api.infra.persistence.returnrule;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ReturnRuleRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReturnRuleRepositoryImpl  implements ReturnRuleRepository {

    private final ReturnRuleJpaRepository jpaRepository;

    public ReturnRuleRepositoryImpl(ReturnRuleJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;

    }

    @Override
    public ReturnRule save(ReturnRule returnRule){
        ReturnRuleJpaEntity jpa = ReturnRuleMapper.toJpaEntity(returnRule);
        ReturnRuleJpaEntity saved = jpaRepository.save(jpa);
        return ReturnRuleMapper.toDomain(saved);

    }

    @Override
    public Optional<ReturnRule> findById(Long id){
        return jpaRepository.findById(id).map(ReturnRuleMapper::toDomain);

    }

    @Override
    public List<ReturnRule> findAll(){
        return jpaRepository.findAll().stream().map(ReturnRuleMapper::toDomain).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id){
        jpaRepository.deleteById(id);
    }


}
