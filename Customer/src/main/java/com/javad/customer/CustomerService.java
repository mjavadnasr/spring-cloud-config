package com.javad.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepo customerRepo, RestTemplate restTemplate) {
    public void register(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .firstName(customerDTO.firstName())
                .lastName(customerDTO.lastName())
                .email(customerDTO.email())
                .build();

        customerRepo.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject(
                        "http://FRAUD/fraud/{customerId}",
                        FraudCheckResponse.class,
                        customer.getId()
                );

        assert fraudCheckResponse != null;
        if(fraudCheckResponse.isFraudster())
            throw new IllegalStateException("fraudster");
    }
}
