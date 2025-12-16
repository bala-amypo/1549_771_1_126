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
  @Column(nullable=false)
  private LocalDate purchaseDate;
  @Column(nullable=false)
  private String storeLocation;

  //Constructor
  public PurchaseRecord(){

  }
  public PurchaseRecord(Long customerId,Double amount,LocalDate purchaseDate,String storeLocation){
    this.customerId=customerId;
    this.amount=amount;
    this.purchaseDate=purchaseDate;
    this.storeLocation=storeLocation;
  }

  //validation r

    

}

