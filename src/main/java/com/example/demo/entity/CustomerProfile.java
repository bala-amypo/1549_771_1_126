package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "customer_profiles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "customerId"),
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "phone")
        }
)
public class CustomerProfile {

    private static final Set<String> CUSTOMER_IDS = new HashSet<>();
    private static final Set<String> EMAILS = new HashSet<>();
    private static final Set<String> PHONES = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerId;

    private String fullName;

    private String email;

    private String phone;

    private String currentTier = "BRONZE";

    private Boolean active = true;

    private LocalDateTime createdAt;

    public CustomerProfile() {
    }

    public CustomerProfile(String customerId, String fullName, String email,
                           String phone, String currentTier,
                           Boolean active, LocalDateTime createdAt) {

        if (CUSTOMER_IDS.contains(customerId))
            throw new IllegalArgumentException("Duplicate customerId");
        if (EMAILS.contains(email))
            throw new IllegalArgumentException("Duplicate email");
        if (PHONES.contains(phone))
            throw new IllegalArgumentException("Duplicate phone");

        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.currentTier = currentTier == null ? "BRONZE" : currentTier;
        this.active = active == null ? true : active;
        this.createdAt = createdAt;

        CUSTOMER_IDS.add(customerId);
        EMAILS.add(email);
        PHONES.add(phone);
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (currentTier == null) currentTier = "BRONZE";
        if (active == null) active = true;
    }

    // ===== Getters & Setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
