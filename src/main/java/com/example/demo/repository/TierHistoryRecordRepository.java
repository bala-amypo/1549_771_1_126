package com.example.demo.repository;

import com.example.demo.entity.TierHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TierHistoryRecordRepository extends JpaRepository<TierHistoryRecord, Long> {

    // Find all tier history records for a specific customer
    List<TierHistoryRecord> findByCustomerId(Long customerId);

    // Find tier history records within a time range
    List<TierHistoryRecord> findByChangedAtBetween(
            LocalDateTime start,
            LocalDateTime end
    );
}
