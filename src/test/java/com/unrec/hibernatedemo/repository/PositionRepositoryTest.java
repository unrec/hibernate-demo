package com.unrec.hibernatedemo.repository;

import com.unrec.hibernatedemo.IntegrationTest;
import com.unrec.hibernatedemo.model.shop.Position;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import static com.unrec.hibernatedemo.utils.TestObjects.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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