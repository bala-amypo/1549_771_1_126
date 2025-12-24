package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;
    private double minSpend;
    private int minVisits;
    private boolean active = true;

    public String getFromTier() { return fromTier; }
    public String getToTier() { return toTier; }
    public double getMinSpend() { return minSpend; }
    public int getMinVisits() { return minVisits; }
    public boolean getActive() { return active; }

    public boolean isActive() { return active; }
    public boolean isPresent() { return true; }
}
