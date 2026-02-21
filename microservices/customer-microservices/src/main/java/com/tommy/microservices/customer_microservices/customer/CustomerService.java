package com.tommy.microservices.customer_microservices.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;


    public String saveCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getDni();
    }

    public CustomerResponse getCustomerById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::toCustomerResponse)
                .orElseThrow();
    }

    public List<CustomerResponse> getCustomers() {
        return repository.findAll().stream()
                .map(mapper::toCustomerResponse)
                .toList();
    }

    public void deleteCustomerById(String customerDni) {
        repository
                .findById(customerDni)
                .orElseThrow();
        repository.deleteById(customerDni);
    }
}
