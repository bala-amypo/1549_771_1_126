package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_profiles")
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String customerId;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String phone;

    // ✅ REQUIRED FOR LOGIN
    @Column(nullable = false)
    private String password;   // BCrypt hashed

    // ✅ REQUIRED FOR AUTHORIZATION
    @Column(nullable = false)
    private String role;       // ROLE_ADMIN, ROLE_RETAIL_OPERATOR

    private String currentTier;
    private Boolean active;
    private LocalDateTime createdAt;

    public CustomerProfile() {}

    // ✅ AUTO DEFAULTS BEFORE INSERT
    @PrePersist
    protected void onCreate() {
        if (this.currentTier == null) {
            this.currentTier = "BRONZE";
        }
        if (this.active == null) {
            this.active = true;
        }
        if (this.role == null || this.role.isBlank()) {
            this.role = "ROLE_RETAIL_OPERATOR";
        }
        this.createdAt = LocalDateTime.now();
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCurrentTier() {
        return currentTier;
    }

    public void setCurrentTier(String currentTier) {
        this.currentTier = currentTier;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
