package com.example.demo5.service;

import com.example.demo5.model.PurchaseRecord;

import java.util.List;

public interface PurchaseRecordService {

    PurchaseRecord recordPurchase(PurchaseRecord purchase);

    List<PurchaseRecord> getPurchasesByCustomer(Long customerId);

    List<PurchaseRecord> getAllPurchases();

    PurchaseRecord getPurchaseById(Long id);
}
