package com.example.demo5.service;

import com.example.demo5.model.VisitRecord;
import java.util.List;

public interface VisitRecordService {

    VisitRecord recordVisit(VisitRecord visit);

    List<VisitRecord> getVisitsByCustomer(Long customerId);

    List<VisitRecord> getAllVisits();

    VisitRecord getVisitById(Long id);
}
