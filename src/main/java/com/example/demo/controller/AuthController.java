package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.ApiResponse;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomerProfileService customerProfileService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(CustomerProfileService customerProfileService,
                          PasswordEncoder passwordEncoder) {
        this.customerProfileService = customerProfileService;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            // Encode password before saving
            request.setPassword(passwordEncoder.encode(request.getPassword()));

            CustomerProfile createdCustomer = customerProfileService.createCustomer(request);
            return ResponseEntity.ok(createdCustomer);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new ApiResponse(false, "Registration failed: " + e.getMessage()));
        }
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            CustomerProfile customer = customerProfileService.findByCustomerId(request.getEmail());
            if (customer == null || !passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
                return ResponseEntity
                        .status(401)
                        .body(new ApiResponse(false, "Invalid email or password"));
            }

            return ResponseEntity.ok(new ApiResponse(true, "Login successful", customer));
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new ApiResponse(false, "Login failed: " + e.getMessage()));
        }
    }
}
