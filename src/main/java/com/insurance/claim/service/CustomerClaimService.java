package com.insurance.claim.service;

import com.insurance.claim.domain.Claim;
import com.insurance.claim.domain.ClaimDTO;
import com.insurance.claim.repository.CustomerClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerClaimService {
    @Autowired
    private CustomerClaimRepository customerClaimRepository;

    public ClaimDTO createClaim(ClaimDTO claimDTO) {
        Claim claim = new Claim(claimDTO.claimantName(), claimDTO.policyNumber(), claimDTO.description(), claimDTO.status());
        Claim savedClaim = customerClaimRepository.save(claim);
        return new ClaimDTO(savedClaim.getId(),savedClaim.getClaimantName(), savedClaim.getPolicyNumber(), savedClaim.getDescription(), savedClaim.getStatus());
    }

    public ClaimDTO getClaim(Long id) {
        Claim claim = customerClaimRepository.findById(id).orElseThrow(() -> new RuntimeException("Claim not found"));
        return new ClaimDTO(claim.getId(),claim.getClaimantName(), claim.getPolicyNumber(), claim.getDescription(), claim.getStatus());
    }

    public List<ClaimDTO> getAllClaims() {
        return customerClaimRepository.findAll().stream()
                .map(claim -> new ClaimDTO(claim.getId(),claim.getClaimantName(), claim.getPolicyNumber(), claim.getDescription(), claim.getStatus()))
                .collect(Collectors.toList());
    }

    public ClaimDTO updateClaimStatus(Long id, String status) {
        Claim claim = customerClaimRepository.findById(id).orElseThrow(() -> new RuntimeException("Claim not found"));
        claim.setStatus(status);
        Claim updatedClaim = customerClaimRepository.save(claim);
        return new ClaimDTO(claim.getId(),updatedClaim.getClaimantName(), updatedClaim.getPolicyNumber(), updatedClaim.getDescription(), updatedClaim.getStatus());
    }



    public List<Claim> createMultipleClaims(List<ClaimDTO> claimDTOs) {
        List<Claim> claims = claimDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        return customerClaimRepository.saveAll(claims);
    }

    private Claim convertToEntity(ClaimDTO claimDTO) {
        return new Claim(claimDTO.id(), claimDTO.claimantName(), claimDTO.policyNumber(), claimDTO.description(), claimDTO.status());
    }

    public ClaimDTO convertToDTO(Claim claim) {
        return new ClaimDTO(claim.getId(),claim.getClaimantName(), claim.getPolicyNumber(), claim.getDescription(), claim.getStatus());
    }
    }

