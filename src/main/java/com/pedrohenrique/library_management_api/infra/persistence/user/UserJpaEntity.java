package com.pedrohenrique.library_management_api.infra.persistence.user;

import com.pedrohenrique.library_management_api.core.domain.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private Boolean active;

    private Long addressId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Long profileId;

    private Integer customLoanLimit;

    public UserJpaEntity() {

    }


    public UserJpaEntity(Long id, String name, String cpf, String phone, String password, String email,
                         LocalDate birthDate, LocalDateTime registrationDate, boolean active,
                         Long addressId, Role role, Long profileId, Integer customLoanLimit) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.active = active;
        this.addressId = addressId;
        this.role = role;
        this.profileId = profileId;
        this.customLoanLimit = customLoanLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Integer getCustomLoanLimit() {
        return customLoanLimit;
    }

    public void setCustomLoanLimit(Integer customLoanLimit) {
        this.customLoanLimit = customLoanLimit;
    }
}