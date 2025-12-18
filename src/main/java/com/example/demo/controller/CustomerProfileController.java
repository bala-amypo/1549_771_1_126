package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService customerProfileService;   // Autowired service

    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomer(customer);
    }

    // @GetMapping("/{id}")
    // public CustomerProfile getCustomer(@PathVariable Long id) {
    //     return customerProfileService.getCustomerById(id);
    // }

    @GetMapping
    public List<CustomerProfile> getAll() {
        return customerProfileService.getAllCustomers();
    }

    // @PutMapping("/{id}/tier")
    // public CustomerProfile updateTier(@PathVariable Long id,
    //                                   @RequestParam String newTier) {
    //     return customerProfileService.updateTier(id, newTier);
    // }

    // @PutMapping("/{id}/status")
    // public CustomerProfile updateStatus(@PathVariable Long id,
    //                                     @RequestParam boolean active) {
    //     return customerProfileService.updateStatus(id, active);
    // }

    // @GetMapping("/lookup/{customerId}")
    // public CustomerProfile lookup(@PathVariable String customerId) {
    //     return customerProfileService.findByCustomerId(customerId);
    // }
}
