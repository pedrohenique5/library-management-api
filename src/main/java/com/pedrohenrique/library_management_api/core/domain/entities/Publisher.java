package com.pedrohenrique.library_management_api.core.domain.entities;

public class Publisher {
    private Long id;
    private String name;
    private String cnpj;
    private String phone;

    public Publisher(Long id, String name, String cnpj, String phone) {
        this.id = id;
        setName(name);
        setCnpj(cnpj);
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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        this.name = name;
    }
    public void setCnpj(String cnpj) {
        if (cnpj != null && !cnpj.matches("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")) {
            throw new IllegalArgumentException("CNPJ format is invalid. Expected format: XX.XXX.XXXX/XXXX-XX");
        }
        this.cnpj = cnpj;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}