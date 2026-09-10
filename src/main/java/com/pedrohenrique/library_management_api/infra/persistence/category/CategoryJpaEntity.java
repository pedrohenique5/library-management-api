package com.pedrohenrique.library_management_api.infra.persistence.category;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public CategoryJpaEntity() {
    }

    public CategoryJpaEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    public Long getId() {
        return id;

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;

    }

    public void setId(Long id){
        this.id = id;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;

    }
}
