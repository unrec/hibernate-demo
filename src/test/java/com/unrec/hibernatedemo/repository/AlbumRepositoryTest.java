package com.unrec.hibernatedemo.repository;

import com.unrec.hibernatedemo.IntegrationTest;
import org.junit.jupiter.api.Test;
import static com.unrec.hibernatedemo.utils.TestObjects.*;
import static org.junit.jupiter.api.Assertions.*;

class AlbumRepositoryTest extends IntegrationTest {

    @Test
    void addEmptyAlbum() {
        var expected = albumRepository.save(getTestAlbum());
        var actual = albumRepository.findById(expected.getId()).get();
        assertEquals(1L, albumRepository.count());
        assertEquals(expected, actual);
    }

    @Test
    void addAlbumWithTracks() {
        var actual = getTestAlbum(getTestTracks());
        var expected = albumRepository.save(actual);

        assertEquals(getTestTracks().size(), trackRepository.count());
        assertEquals(1L, albumRepository.count());
        assertEquals(expected, actual);
    }
}