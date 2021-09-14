package com.unrec.hibernatedemo.repository.shop;

import com.unrec.hibernatedemo.model.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
