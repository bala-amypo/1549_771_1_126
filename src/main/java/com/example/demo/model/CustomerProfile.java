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
     @Column(nullable=false)
     private String fullname;
     @Column(nullable=false,unique=true)
     private String email;
     @Column(unique=true)
     private String phone;
     @Column(nullable=false)
     private  String currentTier;
     @Column(nullable=false)
     private Boolean active;
     @Column (nullable=false)
     private LocalDateTime createdAt;

     
}
