package com.encora.CustomerService.Exceptions;


public class CustomerCreationException extends RuntimeException {
    public CustomerCreationException(String message) {
        super(message);
    }
}
