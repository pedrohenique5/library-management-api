package com.pedrohenrique.library_management_api.core.application.dtos.returnrule.request;

import java.math.BigDecimal;

public record ReturnRuleRequestDTO(
        BigDecimal finePerDayLate
) {
}
