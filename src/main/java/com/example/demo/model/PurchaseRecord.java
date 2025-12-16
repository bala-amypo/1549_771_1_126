package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PurchaseRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

 @Column(nullable=false)
 private Long customerId;  
  @Column(nullable=false)
  private Double amount;

    

}

