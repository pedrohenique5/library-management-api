package com.pedrohenrique.library_management_api.infra.persistence.profile;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class ProfileJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer loanLimit;

    @Column(nullable = false)
    private Integer loanPeriodDays;

    public ProfileJpaEntity(){

    }

    public ProfileJpaEntity(Long id,String name, Integer loanLimit, Integer loanPeriodDays){
        this.id = id;
        this.name = name;
        this.loanLimit = loanLimit;
        this.loanPeriodDays = loanPeriodDays;

    }

    public Long getId() {
        return id;

    }

    public String getName() {
        return name;

    }

    public Integer getLoanLimit() {
        return loanLimit;

    }

    public Integer getLoanPeriodDays() {
        return loanPeriodDays;

    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;

    }

    public void setLoanLimit(Integer loanLimit) {
        this.loanLimit = loanLimit;

    }

    public void setLoanPeriodDays(Integer loanPeriodDays) {
        this.loanPeriodDays = loanPeriodDays;

    }
}
