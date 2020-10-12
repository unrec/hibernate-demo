package com.unrec.hibernatedemo;

import com.unrec.hibernatedemo.repository.AlbumRepository;
import com.unrec.hibernatedemo.repository.ArtistRepository;
import com.unrec.hibernatedemo.repository.OrderRepository;
import com.unrec.hibernatedemo.repository.PositionRepository;
import com.unrec.hibernatedemo.repository.TrackRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class IntegrationTest {

    @Autowired
    protected OrderRepository orderRepository;
    @Autowired
    protected PositionRepository positionRepository;

    @Autowired
    protected TrackRepository trackRepository;
    @Autowired
    protected AlbumRepository albumRepository;
    @Autowired
    protected ArtistRepository artistRepository;

    @AfterEach
    void clearDb() {
        orderRepository.deleteAll();
        positionRepository.deleteAll();

        trackRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();
    }
}