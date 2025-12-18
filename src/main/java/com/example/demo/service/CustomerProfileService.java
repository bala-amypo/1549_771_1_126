package com.example.demo5.service;

import com.example.demo5.model.CustomerProfile;

import java.util.List;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile customer);

    CustomerProfile getCustomerById(Long id);

    CustomerProfile findByCustomerId(String customerId);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile updateTier(Long id, String newTier);

    CustomerProfile updateStatus(Long id, boolean active);
}
