package com.pedrohenrique.library_management_api.core.domain.entities;

import java.math.BigDecimal;

public class ReturnRule {
    private Long id;
    private BigDecimal finePerDayLate;

    public ReturnRule(Long id, BigDecimal finePerDayLate) {
        this.id = id;
        setFinePerDayLate(finePerDayLate);
    }

    public Long getId() { return id; }
    public BigDecimal getFinePerDayLate() { return finePerDayLate; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setFinePerDayLate(BigDecimal finePerDayLate) {
        if (finePerDayLate != null && finePerDayLate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("finePerDayLate cannot be negative");
        }
        this.finePerDayLate = finePerDayLate;
    }
}