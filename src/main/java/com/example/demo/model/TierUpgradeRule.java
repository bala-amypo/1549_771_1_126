package com.example.demo.model;
import jakarta.persistence.*;

@Entity
public class TierUpgradeRule{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String formTier
}