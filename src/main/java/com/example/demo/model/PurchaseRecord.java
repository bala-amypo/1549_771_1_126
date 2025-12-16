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

  //validation rule
@PrePersist
@PreUpdate
private void validateAmount(){
    if(amount==null ||amount<=0){
        throw new IllegalArgumentException("Amount must be >0");
    }
}
//getters and setters

public Long getId(){
    return id;
}
public Long getCustomerId(){
    return customerId;
}
public Double getAmount(){
    return amount;
}
public LocalDate getPurchaseDate(){
    return purchaseDate;
}
public String getstoreLocation(){
    return 
}
public void setCustomerId(Long customerId){
    this.customerId;
}
public void setAmount(Double amount){
    this.amount=amount;
}
public void setPurchaseDate(LocalDate purchaseDate){
    this.purchaseDate=purchaseDate;
}
public void setStoreLocat
    

}

