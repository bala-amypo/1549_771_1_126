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
