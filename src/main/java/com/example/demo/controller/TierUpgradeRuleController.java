package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService tierUpgradeRuleService;

        // Constructor injection
            public TierUpgradeRuleController(TierUpgradeRuleService tierUpgradeRuleService) {
                    this.tierUpgradeRuleService = tierUpgradeRuleService;
                        }

                            // 1️⃣ POST /api/tier-rules → Create a new rule
                                @PostMapping
                                    public ResponseEntity<TierUpgradeRule> createRule(@RequestBody TierUpgradeRule rule) {
                                            TierUpgradeRule createdRule = tierUpgradeRuleService.createRule(rule);
                                                    return ResponseEntity.ok(createdRule);
                                                        }

                                                            // 2️⃣ PUT /api/tier-rules/{id} → Update an existing rule
                                                                @PutMapping("/{id}")
                                                                    public ResponseEntity<TierUpgradeRule> updateRule(
                                                                                @PathVariable Long id,
                                                                                            @RequestBody TierUpgradeRule rule) {
                                                                                                    TierUpgradeRule updatedRule = tierUpgradeRuleService.updateRule(id, rule);
                                                                                                            return ResponseEntity.ok(updatedRule);
                                                                                                                }

                                                                                                                    // 3️⃣ GET /api/tier-rules/active → Get all active rules
                                                                                                                        @GetMapping("/active")
                                                                                                                            public ResponseEntity<List<TierUpgradeRule>> getActiveRules() {
                                                                                                                                    List<TierUpgradeRule> activeRules = tierUpgradeRuleService.getActiveRules();
                                                                                                                                            return ResponseEntity.ok(activeRules);
                                                                                                                                                }

                                                                                                                                                    // 4️⃣ GET /api/tier-rules → Get all rules
                                                                                                                                                        @GetMapping
                                                                                                                                                            public ResponseEntity<List<TierUpgradeRule>> getAllRules() {
                                                                                                                                                                    List<TierUpgradeRule> allRules = tierUpgradeRuleService.getAllRules();
                                                                                                                                                                            return ResponseEntity.ok(allRules);
                                                                                                                                                                                }

                                                                                                                                                                                    // 5️⃣ GET /api/tier-rules/lookup?fromTier=BRONZE&toTier=SILVER → Get specific rule
                                                                                                                                                                                        @GetMapping("/lookup")
                                                                                                                                                                                            public ResponseEntity<TierUpgradeRule> getRule(
                                                                                                                                                                                                        @RequestParam String fromTier,
                                                                                                                                                                                                                    @RequestParam String toTier) {
                                                                                                                                                                                                                            TierUpgradeRule rule = tierUpgradeRuleService.getRule(fromTier, toTier);
                                                                                                                                                                                                                                    return ResponseEntity.ok(rule);
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        