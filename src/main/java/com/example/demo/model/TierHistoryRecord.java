package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TierHistoryRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private Long customerId;
    @Column(nullable=false)
    private String oldTier;
    @Column(nullable=false)
    private String newTier;
    @Column(nullable=false)
    private String reason;
    @Column(nullable=false)
    private LocalDateTime changedAt;

    //constructors
    

}