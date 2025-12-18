package com.example.demo5.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_profiles")
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String customerId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String currentTier;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false, updatable = false)
    @JsonIgnore
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.currentTier = "BRONZE";   // RULE APPLIED
        this.active = true;
        this.createdAt = LocalDateTime.now(); // RULE APPLIED
    }

    // getters & setters
    // NO setter for createdAt
public CustomerProfile(){}
    public CustomerProfile(String customerId, String fullName, String email, String phone, String currentTier,
            Boolean active) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.currentTier = currentTier;
        this.active = active;
    
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCurrentTier(String currentTier) {
        this.currentTier = currentTier;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    

    public Long getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCurrentTier() {
        return currentTier;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    
}

