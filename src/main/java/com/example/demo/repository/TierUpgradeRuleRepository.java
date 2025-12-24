package com.example.demo.repository;

import com.example.demo.model.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {

    TierUpgradeRule getRule(Long id);
    List<TierUpgradeRule> findByActiveTrue();
TierUpgradeRule findByFromTierAndToTier(String fromTier, String toTier);

}
