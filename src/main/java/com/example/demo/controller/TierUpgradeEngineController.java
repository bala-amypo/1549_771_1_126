package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/api/tier-engine")
@Tag(name = "Tier Upgrade Engine")
public class TierUpgradeEngineController {
    private final TierUpgradeEngineService service;
    public TierUpgradeEngineController(TierUpgradeEngineService service) { this.service = service; }
    
    @GetMapping
    public List<TierHistoryRecord> getAllHistory() { return service.getAllHistory(); }
    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistory(@PathVariable Long customerId) { return service.getHistoryByCustomer(customerId); }
    @PostMapping("/evaluate/{customerId}")
    public TierHistoryRecord evaluate(@PathVariable Long customerId) { return service.evaluateAndUpgradeTier(customerId); }
    
   
}