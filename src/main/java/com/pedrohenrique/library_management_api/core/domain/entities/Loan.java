package com.pedrohenrique.library_management_api.core.domain.entities;

import com.pedrohenrique.library_management_api.core.domain.enums.LoanStatus;

import java.time.LocalDate;

public class Loan {
    private Long id;
    private Long userId;
    private Long copyId;
    private Long employeeId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate customDueDate;
    private LocalDate returnDate;
    private boolean renewed;
    private LoanStatus status;

    public Loan(Long id, Long userId, Long copyId, Long employeeId, LocalDate loanDate,
                LocalDate dueDate, LocalDate customDueDate, LocalDate returnDate,
                boolean renewed, LoanStatus status) {
        this.id = id;
        this.userId = userId;
        this.copyId = copyId;
        this.employeeId = employeeId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.customDueDate = customDueDate;
        this.returnDate = returnDate;
        this.renewed = renewed;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getCopyId() { return copyId; }
    public Long getEmployeeId() { return employeeId; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getCustomDueDate() { return customDueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isRenewed() { return renewed; }
    public LoanStatus getStatus() { return status; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setCustomDueDate(LocalDate customDueDate) {
        this.customDueDate = customDueDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public void setRenewed(boolean renewed) {
        this.renewed = renewed;
    }
    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}