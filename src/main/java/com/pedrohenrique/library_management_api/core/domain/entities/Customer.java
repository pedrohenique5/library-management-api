package com.pedrohenrique.library_management_api.core.domain.entities;

public class Customer {
    private Long id;
    private Long userId;

    public Customer(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
