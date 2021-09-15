package com.unrec.hibernatedemo;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import com.unrec.hibernatedemo.repository.library.AlbumRepository;
import com.unrec.hibernatedemo.repository.library.ArtistRepository;
import com.unrec.hibernatedemo.repository.library.TrackRepository;
import com.unrec.hibernatedemo.repository.shop.OrderRepository;
import com.unrec.hibernatedemo.repository.shop.PositionRepository;
import java.util.function.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.support.TransactionTemplate;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
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

    @Autowired
    protected TransactionTemplate txTemplate;

    @AfterEach
    void clearDb() {
        orderRepository.deleteAll();
        positionRepository.deleteAll();

        trackRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();
    }

    public <T> T doInTransaction(Supplier<T> method) {
        return txTemplate.execute(tx -> method.get());
    }

    public void doInTransactionVoid(Runnable method) {
        txTemplate.execute(tx -> {
            method.run();
            return tx;
        });
    }
}