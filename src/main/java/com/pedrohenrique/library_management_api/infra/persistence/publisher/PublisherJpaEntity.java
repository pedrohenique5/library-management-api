package com.pedrohenrique.library_management_api.infra.persistence.publisher;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class PublisherJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String phone;

    public PublisherJpaEntity(){

    }

    public PublisherJpaEntity(Long id,String name, String cnpj, String phone){
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;

    }

    public Long getId() {
        return id;

    }

    public String getName() {
        return name;

    }

    public String getCnpj() {
        return cnpj;

    }

    public String getPhone() {
        return phone;

    }

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
