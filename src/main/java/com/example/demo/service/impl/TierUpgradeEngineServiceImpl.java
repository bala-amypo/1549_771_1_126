package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.VisitRecord;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
            TierHistoryRecordRepository tierHistoryRecordRepository) {

        this.customerProfileRepository = customerProfileRepository;
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.visitRecordRepository = visitRecordRepository;
        this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
        this.tierHistoryRecordRepository = tierHistoryRecordRepository;
    }

    @Override
    public TierHistoryRecord evaluateAndUpgradeTier(Long customerId) {

        CustomerProfile customer = customerProfileRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        // Total spend
        List<PurchaseRecord> purchases =
                purchaseRecordRepository.findByCustomerId(customer.getCustomerId());

        double totalSpend = purchases.stream()
                .mapToDouble(PurchaseRecord::getAmount)
                .sum();

        // Total visits
        List<VisitRecord> visits =
                visitRecordRepository.findByCustomerId(customer.getCustomerId());

        int totalVisits = visits.size();

        String currentTier = customer.getCurrentTier();

        // Active rules
        List<TierUpgradeRule> rules =
                tierUpgradeRuleRepository.findByActiveTrue();

        for (TierUpgradeRule rule : rules) {

            if (!rule.getFromTier().equalsIgnoreCase(currentTier)) {
                continue;
            }

            boolean spendMet =
                    rule.getMinSpend() != null && totalSpend >= rule.getMinSpend();

            boolean visitsMet =
                    rule.getMinVisits() != null && totalVisits >= rule.getMinVisits();

            if (spendMet && visitsMet) {

                String oldTier = currentTier;
                String newTier = rule.getToTier();

                customer.setCurrentTier(newTier);
                customerProfileRepository.save(customer);

                TierHistoryRecord history = new TierHistoryRecord();
                history.setCustomerId(customer.getCustomerId());
                history.setFromTier(oldTier);
                history.setToTier(newTier);
                history.setReason("Upgraded from " + oldTier + " to " + newTier);
                history.setUpgradeTime(LocalDateTime.now());

                return tierHistoryRecordRepository.save(history);
            }
        }

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
