package com.unrec.hibernatedemo.repository.shop;

import com.unrec.hibernatedemo.model.shop.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

}
