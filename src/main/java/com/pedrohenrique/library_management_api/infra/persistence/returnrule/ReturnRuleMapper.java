package com.pedrohenrique.library_management_api.infra.persistence.returnrule;

import com.pedrohenrique.library_management_api.core.domain.entities.ReturnRule;

public class ReturnRuleMapper {

    public static ReturnRule toDomain(ReturnRuleJpaEntity jpa){
        return new ReturnRule(jpa.getId(), jpa.getFinePerDayLate());
    }

    public static ReturnRuleJpaEntity toJpaEntity(ReturnRule domain){
        return new ReturnRuleJpaEntity(domain.getId(), domain.getFinePerDayLate());
    }
}
