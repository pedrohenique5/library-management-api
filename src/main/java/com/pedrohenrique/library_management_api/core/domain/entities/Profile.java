package com.pedrohenrique.library_management_api.core.domain.entities;

public class Profile {
    private Long id;
    private String name;
    private Integer loanLimit;
    private Integer loanPeriodDays;

    public Profile(Long id, String name, Integer loanLimit, Integer loanPeriodDays) {
        this.id = id;
        this.name = name;
        setLoanLimit(loanLimit);
        setLoanPeriodDays(loanPeriodDays);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Integer getLoanLimit() { return loanLimit; }
    public Integer getLoanPeriodDays() { return loanPeriodDays; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLoanLimit(Integer loanLimit) {
        if (loanLimit == null || loanLimit <= 0) {
            throw new IllegalArgumentException("loanLimit deve ser maior que zero");
        }
        this.loanLimit = loanLimit;
    }
    public void setLoanPeriodDays(Integer loanPeriodDays) {
        if (loanPeriodDays == null || loanPeriodDays <= 0) {
            throw new IllegalArgumentException("loanPeriodDays deve ser maior que zero");
        }
        this.loanPeriodDays = loanPeriodDays;
    }
}