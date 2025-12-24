package com.example.demo.repository;

import com.example.demo.model.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {

    VisitRecord getVisitById(Long id);
}
