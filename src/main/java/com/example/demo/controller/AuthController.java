package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomerProfileService customerProfileService;

    public AuthController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        CustomerProfile customer = new CustomerProfile();
        customer.setEmail(request.getEmail());
        customer.setFullName(request.getFullName());
        customer.setPhone(request.getPhone());
        customer.setActive(true);

        CustomerProfile savedCustomer =
                customerProfileService.createCustomer(customer);

        return ResponseEntity.ok(savedCustomer);
    }

    // ---------------- LOGIN (DUMMY) ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("token", "DUMMY-TOKEN-" + request.getEmail());
        response.put("email", request.getEmail());

        return ResponseEntity.ok(response);
    }
}
