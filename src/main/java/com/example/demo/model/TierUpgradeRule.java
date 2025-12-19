package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_upgrade_rules")
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromTier;

    @Column(nullable = false)
    private String toTier;

    @Column(nullable = false)
    private double minSpend;

    @Column(nullable = false)
    private long minVisits;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private String reason;

    public String getFromTier() {
        return fromTier;
    }

    public String getToTier() {
        return toTier;
    }

    public double getMinSpend() {
        return minSpend;
    }

    public long getMinVisits() {
        return minVisits;
    }

    public boolean isActive() {
        return active;
    }

    public String getReason() {
        return reason;
    }
}
