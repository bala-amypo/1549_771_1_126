package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PurchaseRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    

    private CustomerProfile customer;
    
}

public class PurchaseRecord{
    private long id;
    private long customerId;
    private double amount;
    private LocalDate purchaseDate;
}