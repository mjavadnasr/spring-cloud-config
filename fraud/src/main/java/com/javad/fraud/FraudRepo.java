package com.javad.fraud;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepo extends JpaRepository<Fraud , Integer> {
}
