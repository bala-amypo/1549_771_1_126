package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.util.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomerProfileService customerProfileService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    // ==========================
    // Constructor Injection
    // ==========================
    public AuthController(
            CustomerProfileService customerProfileService,
            JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder
    ) {
        this.customerProfileService = customerProfileService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ======================================================
    // POST /auth/register
    // Public
    // ======================================================
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<CustomerProfile>> register(
            @RequestBody RegisterRequest request
    ) {

        CustomerProfile customer =
                customerProfileService.createCustomer(request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "User registered successfully",
                        customer
                )
        );
    }

    // ======================================================
    // POST /auth/login
    // Public
    // ======================================================
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(
            @RequestBody LoginRequest request
    ) {

        // 1️⃣ Find customer by email
        CustomerProfile customer =
                customerProfileService.findByEmail(request.getEmail());

        // 2️⃣ Validate password
        if (!passwordEncoder.matches(
                request.getPassword(),
                customer.getPassword()
        )) {
            return ResponseEntity.status(401).body(
                    new ApiResponse<>(false, "Invalid email or password")
            );
        }

        // 3️⃣ Generate JWT token
        String token = jwtUtil.generateToken(
                customer.getId(),
                customer.getEmail(),
                customer.getRole()
        );

        // 4️⃣ Return token
        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Login successful",
                        token
                )
        );
    }
}
