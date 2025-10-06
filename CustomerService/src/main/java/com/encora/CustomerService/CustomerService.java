package com.encora.CustomerService;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.encora.CustomerService.Exceptions.CustomerCreationException;
import com.encora.CustomerService.Exceptions.CustomerNotFoundException;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new CustomerCreationException("Failed to create customer: " + e.getMessage());
        }
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));
    }
}
