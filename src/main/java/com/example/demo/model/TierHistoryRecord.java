package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_history_records")
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // IMPORTANT: customerId MUST be String
    @Column(nullable = false)
    private String customerId;

    @Column(nullable = false)
    private String fromTier;

    @Column(nullable = false)
    private String toTier;

    @Column(nullable = false)
    private LocalDateTime upgradeTime;

    public TierHistoryRecord() {}

    // getters
    public Long getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFromTier() {
        return fromTier;
    }

    public String getToTier() {
        return toTier;
    }

    public LocalDateTime getUpgradeTime() {
        return upgradeTime;
    }

    // setters
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFromTier(String fromTier) {
        this.fromTier = fromTier;
    }

    public void setToTier(String toTier) {
        this.toTier = toTier;
    }

    public void setUpgradeTime(LocalDateTime upgradeTime) {
        this.upgradeTime = upgradeTime;
    }
}
