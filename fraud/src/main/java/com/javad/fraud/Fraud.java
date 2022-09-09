package com.javad.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Fraud {
    @Id
    @SequenceGenerator(name = "seq" , sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

}
