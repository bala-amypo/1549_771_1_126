package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "customer_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "customer_id"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
    }
)
public class CustomerProfile {

    // ================= PRIMARY KEY =================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ================= BUSINESS IDENTIFIER =================
    @Column(name = "customer_id", nullable = false)
    private String customerId;

    // ================= BASIC DETAILS =================
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    // ================= SECURITY =================
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    // ================= LOYALTY =================
    @Column(nullable = false)
    private String currentTier = "BRONZE";

    // ================= STATUS =================
    @Column(nullable = false)
    private Boolean active = true;

    // ================= AUDIT =================
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // ================= CONSTRUCTORS =================
    public CustomerProfile() {
    }

    public CustomerProfile(
            String customerId,
            String fullName,
            String email,
            String phone,
            String password,
            String role,
            String currentTier,
            Boolean active,
            LocalDateTime createdAt
    ) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;

        if (currentTier != null) {
            this.currentTier = currentTier;
        }
        if (active != null) {
            this.active = active;
        }
        this.createdAt = createdAt;
    }

    // ================= JPA CALLBACK =================
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.currentTier == null) {
            this.currentTier = "BRONZE";
        }
        if (this.active == null) {
            this.active = true;
        }
    }

    // ================= GETTERS & SETTERS =================
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
