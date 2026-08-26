package com.pedrohenrique.library_management_api.infra.persistence.author;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
public class AuthorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String nationality;

    @Column(nullable = false)
    LocalDate birthDate;

    public AuthorJpaEntity(){

    }

    public AuthorJpaEntity(Long id, String name, String nationality, LocalDate birthDate){
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;

    }

    public Long getId() {
        return id;

    }

    public String getName() {
        return name;

    }

    public String getNationality(){
        return nationality;

    }

    public LocalDate getBirthDate(){
        return birthDate;

    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;

    }

    public void setNationality(String nationality){
        this.nationality = nationality;

    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
        
    }
}
