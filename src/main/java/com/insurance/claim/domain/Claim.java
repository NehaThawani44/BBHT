package com.insurance.claim.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String claimantName;
    private String policyNumber;
    private String description;
    private String status;

    // Default constructor required by JPA
    public Claim() {}

    public Claim(Long id, String claimantName, String policyNumber, String description, String status) {
        this.id = id;
        this.claimantName = claimantName;
        this.policyNumber = policyNumber;
        this.description = description;
        this.status = status;
    }

    public Claim(String claimantName, String policyNumber, String description, String status) {
        this.claimantName = claimantName;
        this.policyNumber = policyNumber;
        this.description = description;
        this.status = status;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClaimantName() { return claimantName; }
    public void setClaimantName(String claimantName) { this.claimantName = claimantName; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


}
