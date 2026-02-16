package com.tommy.microservices.customer_microservices.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;


    public String createCustomer(CustomerRequest request) {
        var customer = mapper.toCustomer(request);
        var savedCustomer = repository.save(customer);
        return savedCustomer.getDni();
    }

}
