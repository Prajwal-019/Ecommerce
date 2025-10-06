package com.encora.CustomerService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customerservice/customers")
public class CustomerController {

    private final CustomerService service;
    private final ProductClient client;
    private final OrderClient orderClient;

    public CustomerController(CustomerService service, ProductClient client, OrderClient orderClient) {
        this.service = service;
        this.client = client;
        this.orderClient = orderClient;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }

    // ✅ Only match numeric IDs
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Long id) {
        Customer customer = service.findById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/products")
    public ResponseEntity<?> showAllProducts() {
        return client.getProducts();
    }

    @PostMapping("/placeorder")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequestDTO orderRequest) {
        return orderClient.placeOrder(orderRequest);
    }
}