package com.javad.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService {
    @Autowired
    private FraudRepo fraudRepo;

    public Boolean isFraudulentCustomer(Integer customerId) {
        fraudRepo.save(
                Fraud.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
