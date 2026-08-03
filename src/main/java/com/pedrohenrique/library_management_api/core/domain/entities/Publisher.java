package com.pedrohenrique.library_management_api.core.domain.entities;

public class Publisher {
    private Long id;
    private String name;
    private String cnpj;
    private String phone;

    public Publisher(Long id, String name, String cnpj, String phone) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCnpj() { return cnpj; }
    public String getPhone() { return phone; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}