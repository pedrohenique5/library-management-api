package com.pedrohenrique.library_management_api.core.application.usecases.returnrule;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.ReturnRuleRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.returnrule.request.ReturnRuleRequestDTO;
import com.pedrohenrique.library_management_api.core.application.exceptions.ReturnRuleNotFoundException;
import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;
import org.springframework.stereotype.Component;

@Component
public class UpdateReturnRuleUseCase {
    private final ReturnRuleRepository returnRuleRepository;
    public UpdateReturnRuleUseCase(ReturnRuleRepository returnRuleRepository) {
        this.returnRuleRepository = returnRuleRepository;

    }

    public ReturnRule execute(Long id, ReturnRuleRequestDTO dto){
        ReturnRule existing = returnRuleRepository.findById(id).orElseThrow(ReturnRuleNotFoundException::new);
        existing.setFinePerDayLate(dto.finePerDayLate());
        return returnRuleRepository.save(existing);
    }
}
