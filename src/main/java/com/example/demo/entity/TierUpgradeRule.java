package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "tier_upgrade_rules",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"fromTier", "toTier"})
        }
)
public class TierUpgradeRule {

    private static final Set<String> RULE_KEYS = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private Boolean active = true;

    public TierUpgradeRule() {
    }

    public TierUpgradeRule(String fromTier, String toTier,
                           Double minSpend, Integer minVisits,
                           Boolean active) {

        String key = fromTier + "->" + toTier;
        if (RULE_KEYS.contains(key))
            throw new IllegalArgumentException("Duplicate rule");

        if (minSpend < 0 || minVisits < 0)
            throw new IllegalArgumentException("Invalid rule values");

        this.fromTier = fromTier;
        this.toTier = toTier;
        this.minSpend = minSpend;
        this.minVisits = minVisits;
        this.active = active == null ? true : active;

        RULE_KEYS.add(key);
    }

    // ===== Getters & Setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFromTier() { return fromTier; }
    public void setFromTier(String fromTier) { this.fromTier = fromTier; }

    public String getToTier() { return toTier; }
    public void setToTier(String toTier) { this.toTier = toTier; }

    public Double getMinSpend() { return minSpend; }
    public void setMinSpend(Double minSpend) { this.minSpend = minSpend; }

    public Integer getMinVisits() { return minVisits; }
    public void setMinVisits(Integer minVisits) { this.minVisits = minVisits; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
