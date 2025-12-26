package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Profiles")
public class CustomerProfileController {
    private final CustomerProfileService service;
    public CustomerProfileController(CustomerProfileService service) {
         this.service = service; 
         }

    @PostMapping
    public CustomerProfile create(@RequestBody CustomerProfile c) { return service.createCustomer(c); }
    @GetMapping
    public List<CustomerProfile> getAll() { return service.getAllCustomers(); }
    @GetMapping("/{id}")
    public CustomerProfile getById(@PathVariable Long id) { return service.getCustomerById(id); }
     @GetMapping("/lookup/{customerId}")
    public CustomerProfile lookup(@PathVariable String customerId) {
        return service.findByCustomerId(customerId).orElseThrow(() -> new java.util.NoSuchElementException("Customer not found"));
    }
    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(@PathVariable Long id, @RequestParam String newTier) { return service.updateTier(id, newTier); }
    @GetMapping("/lookup/{customerId}")
    public CustomerProfile lookup(@PathVariable String customerId) {
        return service.findByCustomerId(customerId).orElseThrow(() -> new java.util.NoSuchElementException("Customer not found"));
    }
}