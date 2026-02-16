package com.tommy.microservices.customer_microservices.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .dni(request.dni())
                .nombre(request.nombre())
                .apellido(request.apellido())
                .email(request.email())
                .build();
    }
}
