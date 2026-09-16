package com.pedrohenrique.library_management_api.core.application.usecases.returnrule;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ReturnRuleRepository;
import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListReturnRulesUseCase {
    private final ReturnRuleRepository returnRuleRepository;
    public ListReturnRulesUseCase(ReturnRuleRepository returnRuleRepository) {
        this.returnRuleRepository = returnRuleRepository;

    }

    public List<ReturnRule> execute() {
        return returnRuleRepository.findAll();
    }
}
