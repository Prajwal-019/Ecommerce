package com.encora.OrderService.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.encora.OrderService.ProductClient;
import com.encora.OrderService.Exception.OrderCreationException;
import com.encora.OrderService.Exception.ProductServiceException;
import com.encora.OrderService.Model.Order;
import com.encora.OrderService.Repository.OrderRepository;


@Service
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    public OrderService(ProductClient productClient, OrderRepository orderRepository) {
        this.productClient = productClient;
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Long productId, Long customerId, int quantity, String orderDate) {
        ResponseEntity<?> response = productClient.decreaseQuantity(productId, quantity);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ProductServiceException("Product quantity insufficient or product not found");
        }

        try {
            Order order = new Order();
            order.setProductId(productId);
            order.setCustomerId(customerId);
            order.setQuantity(quantity);
            order.setOrderDate(orderDate);

            return orderRepository.save(order);
        } catch (Exception e) {
            throw new OrderCreationException("Failed to create order: " + e.getMessage());
        }
    }
}
