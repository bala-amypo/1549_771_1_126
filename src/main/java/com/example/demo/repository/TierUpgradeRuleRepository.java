package com.example.demo.repository;

import com.example.demo.model.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TierUpgradeRuleRepository
        extends JpaRepository<TierUpgradeRule, Long> {

    // Active rules
    List<TierUpgradeRule> findByActiveTrue();

    // Specific rule
    Optional<TierUpgradeRule> findByFromTierAndToTier(String fromTier, String toTier);
}
