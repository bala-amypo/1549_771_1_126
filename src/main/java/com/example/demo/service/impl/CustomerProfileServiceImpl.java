package com.example.demo5.service;

import com.example.demo5.model.CustomerProfile;
import com.example.demo5.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    private CustomerProfileRepository customerProfileRepository; 

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return customerProfileRepository.save(customer);
    }

    // @Override
    // public CustomerProfile getCustomerById(Long id) {
    //     return customerProfileRepository.findById(id)
    //             .orElseThrow(() -> new NoSuchElementException("Customer not found with id " + id));
    // }

    

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileRepository.findAll();
    }

    // @Override
    // public CustomerProfile updateTier(Long id, String newTier) {
    //     CustomerProfile customer = getCustomerById(id);
    //     customer.setCurrentTier(newTier);
    //     return customerProfileRepository.save(customer);
    // }

    // @Override
    // public CustomerProfile updateStatus(Long id, boolean active) {
    //     CustomerProfile customer = getCustomerById(id);
    //     customer.setActive(active);
    //     return customerProfileRepository.save(customer);
    // }
}
