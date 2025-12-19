package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerProfileRepository;
    private final PurchaseRecordRepository purchaseRecordRepository;
    private final VisitRecordRepository visitRecordRepository;
    private final TierUpgradeRuleRepository tierUpgradeRuleRepository;
    private final TierHistoryRecordRepository tierHistoryRecordRepository;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerProfileRepository,
            PurchaseRecordRepository purchaseRecordRepository,
            VisitRecordRepository visitRecordRepository,
            TierUpgradeRuleRepository tierUpgradeRuleRepository,
            TierHistoryRecordRepository tierHistoryRecordRepository
    ) {
        this.customerProfileRepository = customerProfileRepository;
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.visitRecordRepository = visitRecordRepository;
        this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
        this.tierHistoryRecordRepository = tierHistoryRecordRepository;
    }

    @Override
    public TierHistoryRecord evaluateAndUpgradeTier(Long customerId) {

        // Fetch customer
        CustomerProfile customer = customerProfileRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        // Calculate total spend
        double totalSpend = purchaseRecordRepository
                .findByCustomerId(customerId)
                .stream()
                .mapToDouble(PurchaseRecord::getAmount)
                .sum();

        // Calculate total visits
        long totalVisits = visitRecordRepository
                .findByCustomerId(customerId)
                .size();

        String currentTier = customer.getCurrentTier();

        // Find active upgrade rules for current tier
        List<TierUpgradeRule> rules =
                tierUpgradeRuleRepository.findByFromTierAndActiveTrue(currentTier);

        for (TierUpgradeRule rule : rules) {
            boolean spendMet = totalSpend >= rule.getMinSpend();
            boolean visitsMet = totalVisits >= rule.getMinVisits();

            if (spendMet && visitsMet) {

                String oldTier = customer.getCurrentTier();
                String newTier = rule.getToTier();

                // Update customer tier
                customer.setCurrentTier(newTier);
                customerProfileRepository.save(customer);

                // Create tier history record
                TierHistoryRecord historyRecord = new TierHistoryRecord(
                        customerId,
                        oldTier,
                        newTier,
                        rule.getReason(),
                        null // changedAt handled by @PrePersist
                );

                return tierHistoryRecordRepository.save(historyRecord);
            }
        }

        // No upgrade applied
        return null;
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return tierHistoryRecordRepository.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return tierHistoryRecordRepository.findAll();
    }
}
