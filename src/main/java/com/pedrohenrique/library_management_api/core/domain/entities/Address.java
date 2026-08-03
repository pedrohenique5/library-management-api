package com.pedrohenrique.library_management_api.core.domain.entities;

public class Address {

    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;

    public Address(Long id, String street,  String number, String complement, String neighborhood,
                   String city, String state, String zipCode){

        this.id = id;
        setStreet(street);
        this.number = number;
        this.complement = complement;
        setNeighborhood(neighborhood);
        setCity(city);
        setState(state);
        setZipCode(zipCode);

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
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("rua é obrigatória");
        }
        this.street = street;

    }

    public void setNumber(String number) {
        this.number = number;

    }

    public void setComplement(String complement) {
        this.complement = complement;

    }

    public void setNeighborhood(String neighborhood) {
        if (neighborhood == null || neighborhood.isBlank()) {
            throw new IllegalArgumentException("bairro é obrigatório");
        }
        this.neighborhood = neighborhood;

    }

    public void setCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("cidade é obrigatória");
        }
        this.city = city;

    }

    public void setState(String state) {
        if (state == null || !state.matches("^[A-Z]{2}$")) {
            throw new IllegalArgumentException("UF deve ter exatamente 2 letras maiúsculas");
        }
        this.state = state;

    }

    public void setZipCode(String zipCode) {
        if (zipCode == null || !zipCode.matches("\\d{5}-?\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido");
        }
        this.zipCode = zipCode;

    }
}
