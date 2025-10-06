package com.encora.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encora.OrderService.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
