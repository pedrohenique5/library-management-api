package com.pedrohenrique.library_management_api.core.application.usecases.returnrule;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ReturnRuleRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.returnrule.request.ReturnRuleRequestDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;
import org.springframework.stereotype.Component;

@Component
public class CreateReturnRuleUseCase {
    private final ReturnRuleRepository returnRuleRepository;

    public CreateReturnRuleUseCase(ReturnRuleRepository returnRuleRepository) {
        this.returnRuleRepository = returnRuleRepository;
    }

    public ReturnRule execute(ReturnRuleRequestDTO dto){
        ReturnRule returnRule = new ReturnRule(null, dto.finePerDayLate());
        return returnRuleRepository.save(returnRule);
    }
}
