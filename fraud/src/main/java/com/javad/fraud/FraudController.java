package com.javad.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud")
public class FraudController {
    @Autowired
    private FraudService fraudService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerId) {

        Boolean isFraud = fraudService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse((isFraud));
    }
}
