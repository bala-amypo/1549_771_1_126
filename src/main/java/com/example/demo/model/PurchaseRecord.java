package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    private CustomerProfile customer;

    // ===== REQUIRED BY TEST =====
    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    public void setId(long id) {
        this.id = id;
    }

    // ===== GETTERS =====
    public CustomerProfile getCustomer() {
        return customer;
    }
}
