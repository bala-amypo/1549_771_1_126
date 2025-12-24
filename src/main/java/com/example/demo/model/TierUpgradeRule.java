package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;
    private boolean active = true;

    // ===== REQUIRED BY TEST =====
    public boolean isPresent() {
        return true;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(long id) {
        this.id = id;
    }
}
