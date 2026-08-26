package com.pedrohenrique.library_management_api.infra.persistence.address;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class AddressJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    private String number;
    private String complement;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 9)
    private String zipCode;

    public AddressJpaEntity() {

    }

    public AddressJpaEntity(Long id, String street, String number, String complement,
                            String neighborhood, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;

        }

        public Long getId() {
        return id;

    }

        public String getStreet() {
        return street;

    }

        public String getNumber() {
        return number;

    }

        public String getComplement() {
        return complement;

    }

        public String getNeighborhood() {
        return neighborhood;

    }

        public String getCity() {
        return city;

    }

        public String getState() {
        return state;

    }

        public String getZipCode() {
        return zipCode;

    }

        public void setId(Long id) {
        this.id = id;

    }

        public void setStreet(String street) {
        this.street = street;


    }
        public void setNumber(String number) {
        this.number = number;

    }

        public void setComplement(String complement) {
        this.complement = complement;

    }

        public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;

    }

        public void setCity(String city) {
        this.city = city;

    }

        public void setState(String state) {
        this.state = state;

    }

        public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}


