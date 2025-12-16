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
private LocalDate visitDate;

@Column(nullable=false)
private String channel;

public VisitRecord(){

}
public VisitRecord(Long customerId,LocalDate visitDate,String channel){
this.customerId=customerId;
this.visitDate=visitDate;
this.channel=channel;
}
//validation
@PrePersist
@PreUpdate
private void valideChannel(){

}

//getters and setters
public Long getId(){
    return id;
}
public Long getCustomerId(){
    return customerId;
}
public String getChannel(){
    return channel;
}
public LocalDate visitDate(){
    return visitDate;
}
public void setCustomerId(){
this.customerId=customerId;
}
public void set
}
