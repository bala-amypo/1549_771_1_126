package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CustomerProfile customer;

    // ===== REQUIRED BY TEST =====
    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    public void setId(long id) {
        this.id = id;
    }
}
