package com.example.demo5.service;

import com.example.demo5.model.TierHistoryRecord;

import java.util.List;

public interface TierUpgradeEngineService {

    TierHistoryRecord evaluateAndUpgradeTier(Long customerId);

    List<TierHistoryRecord> getHistoryByCustomer(Long customerId);

    List<TierHistoryRecord> getAllHistory();
}
