package com.example.demo5.controller;

import com.example.demo5.model.PurchaseRecord;
import com.example.demo5.service.PurchaseRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService purchaseRecordService;

    // Constructor injection
    public PurchaseRecordController(PurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    // 1. POST /api/purchases
    // Access: Protected by JWT
    @PostMapping
    public ResponseEntity<PurchaseRecord> recordPurchase(
            @RequestBody PurchaseRecord purchase) {

        PurchaseRecord savedPurchase =
                purchaseRecordService.recordPurchase(purchase);

        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    // 2. GET /api/purchases/customer/{customerId}
    // Access: Protected by JWT
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PurchaseRecord>> getPurchasesByCustomer(
            @PathVariable Long customerId) {

        List<PurchaseRecord> purchases =
                purchaseRecordService.getPurchasesByCustomer(customerId);

        return ResponseEntity.ok(purchases);
    }

    // 3. GET /api/purchases/{id}
    // Access: Protected by JWT
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseRecord> getPurchaseById(
            @PathVariable Long id) {

        PurchaseRecord purchase =
                purchaseRecordService.getPurchaseById(id);

        return ResponseEntity.ok(purchase);
    }

    // 4. GET /api/purchases
    // Access: Protected by JWT
    @GetMapping
    public ResponseEntity<List<PurchaseRecord>> getAllPurchases() {

        List<PurchaseRecord> purchases =
                purchaseRecordService.getAllPurchases();

        return ResponseEntity.ok(purchases);
    }
}
