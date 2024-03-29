package com.unrec.hibernatedemo.repository.order;

import static com.unrec.hibernatedemo.utils.TestObjects.getTestPosition;
import static com.unrec.hibernatedemo.utils.TestObjects.getTestPositions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.unrec.hibernatedemo.IntegrationTest;
import com.unrec.hibernatedemo.model.shop.Position;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class PositionRepositoryTest extends IntegrationTest {

    @Test
    void addPosition() {
        var expected = getTestPosition();
        Position actual = positionRepository.save(expected);

        assertEquals(expected, actual);
        assertEquals(1, positionRepository.count());
    }

    @Test
    void addPositions() {
        var expected = getTestPositions();
        List<Position> actual = positionRepository.saveAll(expected);

        assertEquals(expected, new HashSet<>(actual));
        assertEquals(expected.size(), positionRepository.count());

    }
}