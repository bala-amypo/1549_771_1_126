package com.example.demo.model;
import jakarta.persistence.*;

@Entity
public class TierUpgradeRule{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String formTier;
    @Column(nullable=false)
    private String toTier;
    @Column(nullable=false)
    private Double minSpend;
    @Column(nullable=false)
    private Integer minVisits;
    @Column(nullable=false)
    private Boolean active;

    //Constructors

    public TierUpgradeRule(){

    }
    public TierUpgradeRule(String formTier,String toTier,Double minSpend,Integer minVisits,Boolean active){
        this.formTier=formTier;
        this.toTier=toTier;
        this.minSpend=minSpend;
        this.minVisits=min
    }
}