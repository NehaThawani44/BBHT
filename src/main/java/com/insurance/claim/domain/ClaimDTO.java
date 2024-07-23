package com.insurance.claim.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
//@Access(AccessType.PROPERTY)
public record ClaimDTO(
        //@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
        Long id,
        String claimantName,
        String policyNumber,
        String description,
        String status
) {


   /* @ConstructorProperties({"id", "claimantName", "policyNumber", "description", "status"})
    public ClaimDTO(String claimantName, String policyNumber, String description, String status) {
    }*/


}
