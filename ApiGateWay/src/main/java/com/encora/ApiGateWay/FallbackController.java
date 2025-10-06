package com.encora.ApiGateWay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@RestController
public class FallbackController {
  
   @GetMapping("/fallback/products")
   public Mono<String> productServiceFallback() {
       return Mono.just("Product service is currently unavailable. Please try again later.");
   }
   
   @GetMapping("/fallback/orders")
   public Mono<String> OrderServiceFallback() {
       return Mono.just("Order service is currently unavailable. Please try again later.");
   }
   
   @GetMapping("/fallback/customers")
   public Mono<String> CustomerServiceFallback() {
       return Mono.just("Customer service is currently unavailable. Please try again later.");
   }
}