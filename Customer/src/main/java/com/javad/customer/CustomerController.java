package com.javad.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public record CustomerController(CustomerService customerService) {

    @PostMapping 
    public void registerCustomer(@RequestBody CustomerDTO customerDTO)
    {
         log.info("new Customer register {}",customerDTO);
         customerService.register(customerDTO);

    }

}
