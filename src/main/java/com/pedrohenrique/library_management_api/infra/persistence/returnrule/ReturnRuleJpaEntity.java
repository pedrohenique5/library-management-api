package com.pedrohenrique.library_management_api.infra.persistence.returnrule;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "return_rules")
public class ReturnRuleJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal finePerDayLate;

    public ReturnRuleJpaEntity(){

    }

    public ReturnRuleJpaEntity(Long id, BigDecimal finePerDayLate){
        this.id = id;
        this.finePerDayLate = finePerDayLate;

    }

    public Long getId() {
        return id;

    }

    public BigDecimal getFinePerDayLate() {
        return finePerDayLate;

    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setFinePerDayLate(BigDecimal finePerDayLate) {
        this.finePerDayLate = finePerDayLate;

    }
}
