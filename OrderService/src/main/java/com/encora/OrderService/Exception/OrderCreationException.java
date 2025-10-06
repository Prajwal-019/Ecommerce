package com.encora.OrderService.Exception;


public class OrderCreationException extends RuntimeException {
    public OrderCreationException(String message) {
        super(message);
    }
}