package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.List;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile customer);

    CustomerProfile getCustomerById(Long id);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile updateTier(Long id, String newTier);

    CustomerProfile findByCustomerId(String customerId);

    void updateStatus(Long id, boolean active);
}
