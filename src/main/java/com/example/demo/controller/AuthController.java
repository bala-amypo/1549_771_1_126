package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.security.JwtUtil;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.payload.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        CustomerProfile customer = new CustomerProfile();
        customer.setEmail(request.getEmail());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setFullName(request.getFullName());
        customer.setPhone(request.getPhone());
        customer.setRole(request.getRole());

        CustomerProfile savedCustomer =
                customerProfileService.createCustomer(customer);

        return ResponseEntity.ok(
                ApiResponse.success("Customer registered successfully", savedCustomer)
        );
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        CustomerProfile customer =
                customerProfileService.findByCustomerId(request.getEmail());

        if (customer == null) {
            return ResponseEntity.status(401)
                    .body(ApiResponse.failure("Invalid email or password"));
        }

        boolean passwordMatch = passwordEncoder.matches(
                request.getPassword(),
                customer.getPassword()
        );

        if (!passwordMatch) {
            return ResponseEntity.status(401)
                    .body(ApiResponse.failure("Invalid email or password"));
        }

        String token = jwtUtil.generateToken(
                customer.getId(),
                customer.getEmail(),
                customer.getRole()
        );

        return ResponseEntity.ok(
                ApiResponse.success("Login successful", token)
        );
    }
}
