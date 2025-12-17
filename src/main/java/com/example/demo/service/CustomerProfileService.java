package com.example.demo.service;

public interface CustomerService {

    CustomerProfile createCustomer(CustomerProfile customer);

    CustomerProfile getCustomerId(Long id);

    CustomerProfile findbyCustomerId(String customerId);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile updateTier(Long id, String newTier);

    CustomerProfile updateStatus(Long id, Boolean active);
}