package com.unrec.hibernatedemo.repository.order;

import static com.unrec.hibernatedemo.utils.TestObjects.getTestOrder;
import static com.unrec.hibernatedemo.utils.TestObjects.getTestPositions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.unrec.hibernatedemo.IntegrationTest;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest extends IntegrationTest {

  @Test
  void addEmptyOrder() {
    var expected = getTestOrder();
    var actual = orderRepository.save(expected);

    assertEquals(expected, actual);
    assertEquals(1, orderRepository.count());
    assertEquals(0, positionRepository.count());
  }

  @Test
  void addOrderWithPositions() {
    var expected = getTestOrder(getTestPositions());
    var actual = orderRepository.save(expected);

    assertEquals(1, orderRepository.count());
    assertEquals(3, positionRepository.count());
  }
}