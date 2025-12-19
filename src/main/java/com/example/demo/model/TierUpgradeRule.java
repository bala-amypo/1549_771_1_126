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

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

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

    public boolean getActive() {   // IMPORTANT: getActive(), not isActive()
        return active;
    }

    public String getReason() {
        return reason;
    }

    // ===== SETTERS =====

    public void setFromTier(String fromTier) {
        this.fromTier = fromTier;
    }

    public void setToTier(String toTier) {
        this.toTier = toTier;
    }

    public void setMinSpend(double minSpend) {
        this.minSpend = minSpend;
    }

    public void setMinVisits(long minVisits) {
        this.minVisits = minVisits;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
