package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService tierUpgradeEngineService;

    public TierUpgradeEngineController(TierUpgradeEngineService tierUpgradeEngineService) {
        this.tierUpgradeEngineService = tierUpgradeEngineService;
    }

    /**
     * Evaluate and upgrade customer tier if criteria is met
     * Access: JWT Protected
     */
    @PostMapping("/evaluate/{customerId}")
    public ResponseEntity<?> evaluateTier(@PathVariable Long customerId) {

        TierHistoryRecord historyRecord =
                tierUpgradeEngineService.evaluateAndUpgradeTier(customerId);

        if (historyRecord == null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("No tier upgrade criteria met");
        }

        return ResponseEntity.ok(historyRecord);
    }

    /**
     * Get tier upgrade history for a specific customer
     * Access: JWT Protected
     */
    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<TierHistoryRecord>> getHistoryByCustomer(
            @PathVariable Long customerId
    ) {
        return ResponseEntity.ok(
                tierUpgradeEngineService.getHistoryByCustomer(customerId)
        );
    }

    /**
     * Get all tier upgrade history records
     * Access: JWT Protected
     */
    @GetMapping
    public ResponseEntity<List<TierHistoryRecord>> getAllHistory() {
        return ResponseEntity.ok(
                tierUpgradeEngineService.getAllHistory()
        );
    }
}
