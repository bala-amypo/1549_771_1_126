package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;

    private Boolean active = true;   // wrapper is better for JPA
    private Double minSpend;
    private Integer minVisits;

    // ✅ GETTERS
    public Long getId() {
        return id;
    }

    public String getFromTier() {
        return fromTier;
    }

    public String getToTier() {
        return toTier;
    }

    public Double getMinSpend() {     // ✅ wrapper
        return minSpend;
    }

    public Integer getMinVisits() {   // ✅ wrapper
        return minVisits;
    }

    public Boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return Boolean.TRUE.equals(active);
    }

    // ✅ SETTERS
    public void setFromTier(String fromTier) {
        this.fromTier = fromTier;
    }

    public void setToTier(String toTier) {
        this.toTier = toTier;
    }

    public void setMinSpend(Double minSpend) {   // ✅ wrapper
        this.minSpend = minSpend;
    }

    public void setMinVisits(Integer minVisits) { // ✅ wrapper
        this.minVisits = minVisits;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
