package com.insurance.claim.controller;

import com.insurance.claim.domain.Claim;
import com.insurance.claim.domain.ClaimDTO;
import com.insurance.claim.service.CustomerClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer-claims")
public class CustomerClaimController {

    @Autowired
    private CustomerClaimService customerClaimService;

    @PostMapping
    public ResponseEntity<ClaimDTO> createClaim(@Valid @RequestBody ClaimDTO claim) {
        return ResponseEntity.ok(customerClaimService.createClaim(claim));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimDTO> getClaim(@PathVariable Long id) {
        return ResponseEntity.ok(customerClaimService.getClaim(id));
    }

    @GetMapping
    public ResponseEntity<List<ClaimDTO>> getAllClaims() {
        return ResponseEntity.ok(customerClaimService.getAllClaims());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaimDTO> updateClaimStatus(@PathVariable Long id, @Valid @RequestBody String status) {
        return ResponseEntity.ok(customerClaimService.updateClaimStatus(id, status));
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<ClaimDTO>> createMultipleClaims(@Valid @RequestBody List<ClaimDTO> claimDTOs) {
        List<Claim> createdClaims = customerClaimService.createMultipleClaims(claimDTOs);
        List<ClaimDTO> createdClaimDTOs = createdClaims.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(createdClaimDTOs, HttpStatus.CREATED);
    }

    private ClaimDTO convertToDTO(Claim claim) {
        return new ClaimDTO(claim.getId(), claim.getClaimantName(), claim.getPolicyNumber(), claim.getDescription(), claim.getStatus());
    }
}