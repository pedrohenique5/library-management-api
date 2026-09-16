package com.pedrohenrique.library_management_api.core.application.usecases.returnrule;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ReturnRuleRepository;
import com.pedrohenrique.library_management_api.core.application.exceptions.ReturnRuleNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeleteReturnRuleUseCase {
    private final ReturnRuleRepository returnRuleRepository;
    public DeleteReturnRuleUseCase(ReturnRuleRepository returnRuleRepository) {
        this.returnRuleRepository = returnRuleRepository;

    }

    public void execute(Long id) {
        returnRuleRepository.findById(id).orElseThrow(ReturnRuleNotFoundException::new);
        returnRuleRepository.delete(id);
    }
}
