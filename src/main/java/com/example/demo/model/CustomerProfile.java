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
     private String fullName;
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


@PrePersist
private void PrePersist(){
    if(currentTier==null){
        currentTier="BRONZE";
    }
    if(createdAt==null){
        createdAt=LocalDateTime.now();
    }
    if(active==null){
        active=true;
    }
}

public Long getId(){
    return id;
}
public String getCustomerId(){
    return customerId;
    
}

public String getfullName(){
    return fullName;
}
public String getemail(){
    return email;
}
public String getphone(){
    return phone;
}
public String getcurrentTier(){
    return currentTier;
}

public String getactive(){
    return active;
}
public String getcreatedAt(){
    return createdAt;
}
public void setId(Long id){
    this.id=id;
}


}
     

