package com.encora.CustomerService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Order Client
@FeignClient(name = "orderservice", url = "http://localhost:9091")
public interface OrderClient {
	
	@PostMapping("/orders")
    ResponseEntity<?> placeOrder(@RequestBody OrderRequestDTO orderRequest);

}
