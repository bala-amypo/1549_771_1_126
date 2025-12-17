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
    public TierHistoryRecord(){

    }
    public TierHistoryRecord(Long customerId,String oldTier,String newTier,String reason){
        this.customerId=customerId;
        this.newTier=newTier;
        this.reason=reason;
        this.changedAt=changedAt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getOldTier() {
        return oldTier;
    }
    public void setOldTier(String oldTier) {
        this.oldTier = oldTier;
    }
    public String getNewTier() {
        return newTier;
    }
    public void setNewTier(String newTier) {
        this.newTier = newTier;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public LocalDateTime getChangedAt() {
        return changedAt;
    }
    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }

    

}