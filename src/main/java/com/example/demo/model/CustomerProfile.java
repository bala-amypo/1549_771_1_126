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
                                                                                                                                    public CustomerProfile(){

                                                                                                                                    }
                                                                                                                                    public CustomerProfile(String customerId,String fullName,String email,String phone,String currentTier,String active){
                                                                                                                                     this.customerId=customerId;
                                                                                                                                     this.fullName=fullName;
                                                                                                                                      this.email=email;
                                                                                                                                      this.phone=phone;
                                                                                                                                      this.currentTier=currentTier;
                                                                                                                                      this.active=active;
                                                                                                                                      this.createdAt=createdAt;
                                                                                                                                      }
                                                                                                                                      public Long getId(){
                                                                                                                                          return id;
                                                                                                                                          }
                                                                                                                                          public String getCustomerId(){
                                                                                                                                              return customerId;
                                                                                                                                                  
                                                                                                                                                  }

                                                                                                                                                  public String getFullName(){
                                                                                                                                                      return fullName;
                                                                                                                                                      }
                                                                                                                                                      public String getEmail(){
                                                                                                                                                          return email;
                                                                                                                                                          }
                                                                                                                                                          public String getPhone(){
                                                                                                                                                              return phone;
                                                                                                                                                              }
                                                                                                                                                              public String getCurrentTier(){
                                                                                                                                                                  return currentTier;
                                                                                                                                                                  }

                                                                                                                                                                  public String getActive(){
                                                                                                                                                                      return active;
                                                                                                                                                                      }
                                                                                                                                                                      public String getCreatedAt(){
                                                                                                                                                                          return createdAt;
                                                                                                                                                                          }
                                                                                                                                                                          public void setId(Long id){
                                                                                                                                                                              this.id=id;
                                                                                                                                                                              }
                                                                                                                                                                              public void setCustomerId(Long customerId){
                                                                                                                                                                                  this.customerId=customerId;
                                                                                                                                                                                  }
                                                                                                                                                                                  public void setFullName(String fullName){
                                                                                                                                                                                      this.fullName=fullName;
                                                                                                                                                                                      }
                                                                                                                                                                                      public void setEmail(String email){
                                                                                                                                                                                          this.email=email;
                                                                                                                                                                                          }
                                                                                                                                                                                          public void setPhone(String phone){
                                                                                                                                                                                              this.phone=phone;
                                                                                                                                                                                              }
                                                                                                                                                                                              public void setCurrentTier(String currentTier){
                                                                                                                                                                                                  this.currentTier=currentTier;
                                                                                                                                                                                                  }
                                                                                                                                                                                                  public void setActive(String active){
                                                                                                                                                                                                      this.active=active;
                                                                                                                                                                                                      }
                                                                                                                                                                                                      public void setCreatedAt(String createdAt){
                                                                                                                                                                                                          this.createdAt=createdAt;
                                                                                                                                                                                                          }


                                                                                                                                                                                                          }
                                                                                                                                                                                                               

                                                                                                                                                                                                               