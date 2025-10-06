package com.encora.OrderService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encora.OrderService.OrderRequestDTO;
import com.encora.OrderService.Model.Order;
import com.encora.OrderService.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	
	@PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequestDTO orderRequest) {
        try {
            Order order = orderService.placeOrder(
                orderRequest.getProductId(),
                orderRequest.getCustomerId(),
                orderRequest.getQuantity(),
                orderRequest.getOrderdate()
            );
            return ResponseEntity.ok(order);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
	

}
