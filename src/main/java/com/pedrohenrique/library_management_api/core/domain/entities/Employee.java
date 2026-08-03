package com.pedrohenrique.library_management_api.core.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private Long id;
    private Long userId;
    private String registrationNumber;
    private String position;
    private LocalDate hireDate;
    private BigDecimal salary;

    public Employee(Long id, Long userId, String registrationNumber, String position,
                    LocalDate hireDate, BigDecimal salary) {
        this.id = id;
        this.userId = userId;
        setRegistrationNumber(registrationNumber);
        setPosition(position);
        this.hireDate = hireDate;
        setSalary(salary);
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getRegistrationNumber() { return registrationNumber; }
    public String getPosition() { return position; }
    public LocalDate getHireDate() { return hireDate; }
    public BigDecimal getSalary() { return salary; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank()) {
            throw new IllegalArgumentException("registrationNumber is required");
        }
        this.registrationNumber = registrationNumber;
    }
    public void setPosition(String position) {
        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException("position is required");
        }
        this.position = position;
    }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
    public void setSalary(BigDecimal salary) {
        if (salary != null && salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("salary cannot be negative");
        }
        this.salary = salary;
    }
}
