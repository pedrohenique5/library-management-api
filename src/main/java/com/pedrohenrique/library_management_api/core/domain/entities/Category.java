package com.pedrohenrique.library_management_api.core.domain.entities;

public class Category {
    private Long id;
    private String name;
    private String description;

    public Category(Long id, String name, String description) {
        this.id = id;
        setName(name);
        this.description = description;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}