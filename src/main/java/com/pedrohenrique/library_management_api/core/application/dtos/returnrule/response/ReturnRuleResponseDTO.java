package com.pedrohenrique.library_management_api.core.application.dtos.returnrule.response;

import java.math.BigDecimal;

public record ReturnRuleResponseDTO(
        Long id, BigDecimal finePerDayLate
) {
}
