package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_records")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key → CustomerProfile.id
    @Column(nullable = false)
    private Long customerId;

    private LocalDateTime visitDate;

    private String channel;

    // No-arg constructor
    public VisitRecord() {
    }

    // Parameterized constructor
    public VisitRecord(Long customerId, LocalDateTime visitDate, String channel) {
        this.customerId = customerId;
        this.visitDate = visitDate;
        this.channel = channel;
    }

    // ===== REQUIRED BY TESTS =====

    public Long getId() {
        return id;
    }

    // Tests require this
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    // ===== KEEP EXISTING SUPPORT METHODS =====

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getChannel() {
        return channel;
    }

    // Relaxed setter (NO exception)
    public void setChannel(String channel) {
        this.channel = channel;
    }
}
