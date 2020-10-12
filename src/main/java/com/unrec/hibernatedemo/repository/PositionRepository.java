package com.unrec.hibernatedemo.repository;

import com.unrec.hibernatedemo.model.shop.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
