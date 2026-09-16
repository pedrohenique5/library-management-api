package com.pedrohenrique.library_management_api.core.application.contracts.repositories;

import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;

import java.util.List;
import java.util.Optional;

public interface ReturnRuleRepository {
    ReturnRule save(ReturnRule returnRule);
    Optional<ReturnRule> findById(Long id);
    List<ReturnRule> findAll();
    void delete(Long id);
}
