package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    /**
     * POST /api/customers
     * Create a new customer profile
     * Access: JWT Protected
     */
    @PostMapping
    public ResponseEntity<CustomerProfile> createCustomer(
            @RequestBody CustomerProfile customer) {

        CustomerProfile createdCustomer =
                customerProfileService.createCustomer(customer);

        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    /**
     * GET /api/customers/{id}
     * Get customer by database ID
     * Access: JWT Protected
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomerById(
            @PathVariable Long id) {

        CustomerProfile customer =
                customerProfileService.getCustomerById(id);

        return ResponseEntity.ok(customer);
    }

    /**
     * GET /api/customers
     * Get all customers
     * Access: JWT Protected
     */
    @GetMapping
    public ResponseEntity<List<CustomerProfile>> getAllCustomers() {

        List<CustomerProfile> customers =
                customerProfileService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }

    /**
     * PUT /api/customers/{id}/tier?newTier=GOLD
     * Update customer tier
     * Access: JWT Protected
     */
    @PutMapping("/{id}/tier")
    public ResponseEntity<CustomerProfile> updateCustomerTier(
            @PathVariable Long id,
            @RequestParam String newTier) {

        CustomerProfile updatedCustomer =
                customerProfileService.updateTier(id, newTier);

        return ResponseEntity.ok(updatedCustomer);
    }

    /**
     * GET /api/customers/lookup/{customerId}
     * Find customer by business customerId
     * Access: JWT Protected
     */
    @GetMapping("/lookup/{customerId}")
    public ResponseEntity<CustomerProfile> findByCustomerId(
            @PathVariable String customerId) {

        CustomerProfile customer =
                customerProfileService.findByCustomerId(customerId);

        return ResponseEntity.ok(customer);
    }
}
