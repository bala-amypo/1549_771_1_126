package com.example.demo.model;

import org.springframework.stereotype.Indexed;

import jakarta.annotation.Generated;

public class CustomerProfile {
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long Id;
     private String customerId;
     private String fullname;
     private String email;
     private String phone;
     private  String currentTier;
     private Boolean active;
     private LocalDateTime createdAt 

     
}
