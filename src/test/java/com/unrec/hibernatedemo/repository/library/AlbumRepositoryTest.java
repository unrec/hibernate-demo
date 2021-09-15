package com.unrec.hibernatedemo.repository.library;

import static com.unrec.hibernatedemo.utils.TestObjects.testAlbum;
import static com.unrec.hibernatedemo.utils.TestObjects.testAlbumWithTracks;
import static com.unrec.hibernatedemo.utils.TestObjects.testTracks;
import static java.util.Objects.deepEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.unrec.hibernatedemo.IntegrationTest;
import org.junit.jupiter.api.Test;

class AlbumRepositoryTest extends IntegrationTest {

  @Test
  void addEmptyAlbum() {

    //given
    var expected = albumRepository.save(testAlbum());

    //when
    var actual = albumRepository.findById(expected.getId()).get();

    //then
    assertEquals(1L, albumRepository.count());
    assertEquals(expected, actual);
  }

  @Test
  void addAlbumWithTracks() {

    //given
    var album = testAlbum();
    var tracks = testTracks();
    tracks.forEach(track -> track.setAlbum(album));
    album.setTracks(tracks);
    albumRepository.save(album);

    //when
    var actual = albumRepository.findById(album.getId()).get();

    //then
    assertEquals(1L, albumRepository.count());
    assertEquals(tracks.size(), trackRepository.count());
    assertEquals(tracks, actual.getTracks());
  }

  @Test
  void updateAlbumNameAndYear() {

    //given
    var album = albumRepository.save(testAlbumWithTracks());
    var id = album.getId();
    var newName = "newName";
    var newYear = 2021;

    //when
    albumRepository.updateNameAndYearById(id, newName, newYear);

    //then
    var actual = albumRepository.findById(id).get();
    assertThat(actual, samePropertyValuesAs(album, "tracks", "name", "year"));
    assertTrue(deepEquals(actual.getTracks().toArray(), album.getTracks().toArray()));
    assertEquals(newName, actual.getName());
    assertEquals(newYear, actual.getYear());
  }
}