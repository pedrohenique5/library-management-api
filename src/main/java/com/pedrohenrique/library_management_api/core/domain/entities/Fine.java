package com.pedrohenrique.library_management_api.core.domain.entities;

import com.pedrohenrique.library_management_api.core.domain.enums.FineStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Fine {
    private Long id;
    private Long loanId;
    private BigDecimal amount;
    private LocalDate generationDate;
    private LocalDate paymentDate;
    private FineStatus status;

    public Fine(Long id, Long loanId, BigDecimal amount, LocalDate generationDate,
                LocalDate paymentDate, FineStatus status) {
        this.id = id;
        this.loanId = loanId;
        this.amount = amount;
        this.generationDate = generationDate;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public Long getLoanId() {
        return loanId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public LocalDate getGenerationDate() {
        return generationDate;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public FineStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setGenerationDate(LocalDate generationDate) {
        this.generationDate = generationDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public void setStatus(FineStatus status) {
        this.status = status;
    }

    public void pay() {
        this.paymentDate = LocalDate.now();
        this.status = FineStatus.PAID;
    }

    public void waive() {
        this.status = FineStatus.WAIVED;
    }
}