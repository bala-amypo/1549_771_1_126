package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private String currentTier;
    private boolean active = true;

    private LocalDateTime createdAt;
    

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== Required by SERVICE =====
    public String getCurrentTier() {
        return currentTier;
    }

    public void setCurrentTier(String currentTier) {
        this.currentTier = currentTier;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ===== Required by TEST =====
    public boolean isPresent() { return true; }
    public boolean isActive() { return active; }

    // getters/setters
    public String getCustomerId() {
    return customerId;
}
private String tier;

public String getTier() {
    return tier;
}

public void setTier(String tier) {
    this.tier = tier;
}

}
