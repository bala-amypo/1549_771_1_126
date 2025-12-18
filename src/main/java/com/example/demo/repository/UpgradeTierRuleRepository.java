package com.example.demo.repository;

import com.example.demo.entity.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {

    // Find a rule by its fromTier and toTier combination
    Optional<TierUpgradeRule> findByFromTierAndToTier(String fromTier, String toTier);

    // Find all active rules (active = true)
    List<TierUpgradeRule> findByActiveTrue();
}
