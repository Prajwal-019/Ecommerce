package com.encora.OrderService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productservices", url = "http://localhost:9090")
public interface ProductClient {
	
	@PutMapping("/products/{id}/decrease")
    ResponseEntity<?> decreaseQuantity(@PathVariable("id") Long id, @RequestParam("quantity") int quantity);

}
