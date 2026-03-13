package com.tommy.microservices.customer_microservices.customer;

import com.tommy.microservices.customer_microservices.exceptions.CustomerNotFoundException;
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
                .orElseThrow(() ->new CustomerNotFoundException(
                String.format("Error, snif snif cliente no encontrado por el DNI %s", customerId)));
    }

    public List<CustomerResponse> getCustomers() {
        return repository.findAll().stream()
                .map(mapper::toCustomerResponse)
                .toList();
    }

    public void deleteCustomerById(String customerId) {
        repository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                String.format("Error, snif snif cliente no encontrado por el DNI %s", customerId)));
        repository.deleteById(customerId);
    }
}
