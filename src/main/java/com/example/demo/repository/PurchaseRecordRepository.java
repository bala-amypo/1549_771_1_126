package com.example.demo.repository;

import com.example.demo.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {

    PurchaseRecord getPurchaseById(Long id);
}
