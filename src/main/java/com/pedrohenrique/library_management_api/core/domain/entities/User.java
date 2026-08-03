package com.pedrohenrique.library_management_api.core.domain.entities;

import com.pedrohenrique.library_management_api.core.domain.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String password;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime registrationDate;
    private Boolean active;
    private Long addressId;
    private Role role;
    private Long profileId;
    private Integer customLoanLimit;

    public User(Long id, String name, String cpf, String phone, String password, String email,
                LocalDate birthDate, LocalDateTime registrationDate, Boolean active,
                Long addressId, Role role, Long profileId, Integer customLoanLimit) {
        this.id = id;
        setName(name);
        setCpf(cpf);
        this.phone = phone;
        setPassword(password);
        setEmail(email);
        this.birthDate = birthDate;
        this.registrationDate = registrationDate != null ? registrationDate : LocalDateTime.now();
        this.active = active;
        this.addressId = addressId;
        this.role = role;
        this.customLoanLimit = customLoanLimit;
        setProfileId(profileId);


    }

    public User(String name, String cpf, String phone, String password, String email,
                LocalDate birthDate, Long addressId, Role role, Long profileId, Integer customLoanLimit) {
        this(null, name, cpf, phone, password, email, birthDate, LocalDateTime.now(), true,
             addressId, role, profileId, customLoanLimit);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public Long getAddressId() {
        return addressId;
    }

    public Role getRole() {
        return role;
    }

    public Long getProfileId() {
        return profileId;
    }

    public Integer getCustomLoanLimit() {
        return customLoanLimit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("nome é obrigatório");
        }
        this.name = name;
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido");
            }
        this.cpf = cpf;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8){
            throw new IllegalArgumentException("Senha deve ter no mínimo 8 caracteres");
        }
        this.password = password;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setProfileId(Long profileId) {
        if (profileId == null && this.customLoanLimit == null) {
            throw new IllegalStateException("Usuário deve ter um Profile vinculado ou um customLoanLimit definido");
        }
        this.profileId = profileId;
    }

    public void setCustomLoanLimit(Integer customLoanLimit) {
        if (customLoanLimit == null && this.profileId == null) {
            throw new IllegalStateException("Usuário deve ter um Profile vinculado ou um customLoanLimit definido");
        }
        this.customLoanLimit = customLoanLimit;
    }
}