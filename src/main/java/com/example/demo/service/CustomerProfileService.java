package com.example.demo.service;

public interface CustomerProfileService {
    createCustomer(CustomerProfile customer );
    getCustomerId(Long  id);
    findbyCustomerId(String customerId);
    getAllCustomers();
    updateTier(Long Id,String newTier);
    updateStatus(Long Id,Boolean active);
    
}