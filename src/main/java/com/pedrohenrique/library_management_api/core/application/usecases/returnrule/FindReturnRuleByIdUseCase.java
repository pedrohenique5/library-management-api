package com.pedrohenrique.library_management_api.core.application.usecases.returnrule;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ReturnRuleRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.ReturnRuleNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;
import org.springframework.stereotype.Component;

@Component
public class FindReturnRuleByIdUseCase {
    private final ReturnRuleRepository returnRuleRepository;
    public FindReturnRuleByIdUseCase(ReturnRuleRepository returnRuleRepository) {
        this.returnRuleRepository = returnRuleRepository;

    }

    public ReturnRule execute(Long id){
        return returnRuleRepository.findById(id).orElseThrow(ReturnRuleNotFoundException::new);
    }
}
