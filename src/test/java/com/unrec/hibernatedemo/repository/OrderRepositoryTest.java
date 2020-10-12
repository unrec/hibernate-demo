package com.unrec.hibernatedemo.repository;

import com.unrec.hibernatedemo.IntegrationTest;
import org.junit.jupiter.api.Test;
import static com.unrec.hibernatedemo.utils.TestObjects.*;
import static org.junit.jupiter.api.Assertions.*;

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