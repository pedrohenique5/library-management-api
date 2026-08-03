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
        this.registrationNumber = registrationNumber;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getRegistrationNumber() { return registrationNumber; }
    public String getPosition() { return position; }
    public LocalDate getHireDate() { return hireDate; }
    public BigDecimal getSalary() { return salary; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public void setPosition(String position) { this.position = position; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }
}
