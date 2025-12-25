package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_records")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key reference to CustomerProfile
    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime purchaseDate;

    @Column(nullable = false)
    private String storeLocation;

    // No-arg constructor
    public PurchaseRecord() {
    }

    // Parameterized constructor
    public PurchaseRecord(Long customerId, Double amount,
                          LocalDateTime purchaseDate, String storeLocation) {
        this.customerId = customerId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.storeLocation = storeLocation;
    }

    // ===== REQUIRED BY TESTS =====

    public Long getId() {
        return id;
    }

    // Tests require this setter
    public void setId(Long id) {
        this.id = id;
    }

    // Tests expect THIS name
    public Double getPurchaseAmount() {
        return amount;
    }

    // Tests expect THIS name
    public void setPurchaseAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    // ===== KEEP EXISTING METHODS (DO NOT REMOVE) =====

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
}
