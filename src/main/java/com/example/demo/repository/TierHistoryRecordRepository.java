package com.example.demo5.repository;

import com.example.demo5.model.TierHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TierHistoryRecordRepository
        extends JpaRepository<TierHistoryRecord, Long> {

    List<TierHistoryRecord> findByCustomerId(Long customerId);
}
