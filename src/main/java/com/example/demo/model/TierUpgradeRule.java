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
        this.minVisits=minVisits;
        this.active=active;
    }

    //validation
    @PrePersist
    @PreUpadate
    private void validateRule(){
        if(minSpend==null || minSpend<0){
            throw new IllegalArgumentException("minSpend must be >=0");
        }

        if(minVisits==null || minVisits<0){
            throw new IllegalArgumentException("minVisits must be >=0");
        }
    }
    //getters and setters
    public Long getId(){
        return id;
    }
    public String getFromTier(){
        return fromTier;
    }
    public String getToTier(){
       return toTier;
    }
    public Double getMinSpend(){
        return minSpend;
    }
    public Integer getMinVisits(){
        return minVisits;
    }
    public Boolean getActive(){
         return  active;
    }

public void setId(){
    this.id=id;
}
    public void setFromTier(){
        this.formTier=formTier;
    }
    public void setToTier(){

    }
    public void setMinSpend(){
        this.minSpend=minSpend;
        this.toTier=toTier;
        
    }
}