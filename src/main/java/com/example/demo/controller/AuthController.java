package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.util.JwtUtil;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomerProfileService customerProfileService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(CustomerProfileService customerProfileService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.customerProfileService = customerProfileService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        CustomerProfile customer = new CustomerProfile();
        customer.setEmail(request.getEmail());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setFullName(request.getFullName());
        customer.setPhone(request.getPhone());
        customer.setRole(request.getRole());
        customer.setActive(true);

        CustomerProfile savedCustomer =
                customerProfileService.createCustomer(customer);

        return ResponseEntity.ok(savedCustomer);
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        CustomerProfile customer =
                customerProfileService.findByEmail(request.getEmail());

        if (customer == null) {
            return ResponseEntity.badRequest()
                    .body("Invalid email or password");
        }

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            return ResponseEntity.badRequest()
                    .body("Invalid email or password");
        }

        // Generate dummy token
        String token = jwtUtil.generateToken(
                customer.getId(),
                customer.getEmail(),
                customer.getRole()
        );

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("customerId", customer.getId());
        response.put("email", customer.getEmail());
        response.put("role", customer.getRole());

        return ResponseEntity.ok(response);
    }
}
