package com.insurance.claim.repository;

import com.insurance.claim.domain.Claim;
import com.insurance.claim.domain.ClaimDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerClaimRepository extends JpaRepository<Claim, Long> {
}
