package com.pedrohenrique.library_management_api.core.domain.entities;

import java.time.LocalDate;

public class Author {
    private Long id;
    private String name;
    private String nationality;
    private LocalDate birthDate;

    public Author(Long id, String name, String nationality, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getNationality() { return nationality; }
    public LocalDate getBirthDate() { return birthDate; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}