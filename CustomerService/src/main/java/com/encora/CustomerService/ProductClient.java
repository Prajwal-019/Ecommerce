package com.encora.CustomerService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(name = "productservices", url = "http://localhost:9090")
public interface ProductClient {

	@GetMapping("/products")
	ResponseEntity<?> getProducts();
}
