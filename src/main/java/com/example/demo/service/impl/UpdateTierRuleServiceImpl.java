package com.example.demo.service.impl;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository tierUpgradeRuleRepository;

    // Constructor injection
    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository tierUpgradeRuleRepository) {
        this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
    }

    // 1️⃣ Create a new rule
    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        validateRule(rule);
        return tierUpgradeRuleRepository.save(rule);
    }

    // 2️⃣ Update an existing rule
    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
        TierUpgradeRule existingRule = tierUpgradeRuleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        // Update fields
        existingRule.setFromTier(updatedRule.getFromTier());
        existingRule.setToTier(updatedRule.getToTier());
        existingRule.setMinSpend(updatedRule.getMinSpend());
        existingRule.setMinVisits(updatedRule.getMinVisits());
        existingRule.setActive(updatedRule.getActive());

        validateRule(existingRule);

        return tierUpgradeRuleRepository.save(existingRule);
    }

    // 3️⃣ Get all active rules
    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleRepository.findByActiveTrue();
    }

    // 4️⃣ Get a rule by fromTier + toTier
    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        Optional<TierUpgradeRule> rule = tierUpgradeRuleRepository.findByFromTierAndToTier(fromTier, toTier);
        return rule.orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    // 5️⃣ Get all rules
    @Override
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleRepository.findAll();
    }

    // ✅ Private helper method to validate rule
    private void validateRule(TierUpgradeRule rule) {
        if (rule.getMinSpend() == null || rule.getMinSpend() < 0) {
            throw new IllegalArgumentException("minSpend must be >= 0");
        }
        if (rule.getMinVisits() == null || rule.getMinVisits() < 0) {
            throw new IllegalArgumentException("minVisits must be >= 0");
        }
    }
}
