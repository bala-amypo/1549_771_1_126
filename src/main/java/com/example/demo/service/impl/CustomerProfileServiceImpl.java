package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository customerProfileRepository;

    public CustomerProfileServiceImpl(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    @Override
    public CustomerProfile getCustomerByCustomerId(String customerId) {
        CustomerProfile customer = customerProfileRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new NoSuchElementException("Customer not found");
        }
        return customer;
    }

    @Override
    public CustomerProfile saveCustomer(CustomerProfile customer) {
        return customerProfileRepository.save(customer);
    }

    @Override
    public void deactivateCustomer(String customerId) {
        CustomerProfile customer = customerProfileRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new NoSuchElementException("Customer not found");
        }
        customer.setActive(false);
        customerProfileRepository.save(customer);
    }
}
