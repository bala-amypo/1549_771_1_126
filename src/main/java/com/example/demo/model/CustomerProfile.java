package com.example.demo.model;

import jakarta persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerProfile {
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long Id;//PK
     @Column(nullable=false,unique=true)
     private String customerId;
     
     private String fullname;
     private String email;
     private String phone;
     private  String currentTier;
     private Boolean active;
     private LocalDateTime createdAt;

     
}
