package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
@Column(nullable=false)
private Long customerId;

@Column(nullable=false)
private LocalDate
}
