package com.tommy.microservices.customer_microservices.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.saveCustomer(request));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("customerId") String customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        return ResponseEntity.ok(service.getCustomers());
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@Valid @RequestBody CustomerRequest request) {
        service.saveCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{customerDni}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("dni") String customerDni) {
        service.deleteCustomerById(customerDni);
        return ResponseEntity.accepted().build();
    }

}
