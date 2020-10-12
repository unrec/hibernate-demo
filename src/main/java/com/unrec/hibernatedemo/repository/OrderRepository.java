package com.unrec.hibernatedemo.repository;

import com.unrec.hibernatedemo.model.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
