package com.unrec.hibernatedemo.utils;

import static java.lang.Boolean.FALSE;

import com.unrec.hibernatedemo.model.library.Album;
import com.unrec.hibernatedemo.model.library.Artist;
import com.unrec.hibernatedemo.model.library.Track;
import com.unrec.hibernatedemo.model.shop.Order;
import com.unrec.hibernatedemo.model.shop.Position;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestObjects {

  /* Order objects */

  public static Position getTestPosition() {
    return new Position("ice cream", 2);
  }

  public static Set<Position> getTestPositions() {
    return Set.of(
        new Position("ice cream", 2),
        new Position("milk", 1),
        new Position("spices", 8));
  }

  public Set<Position> getTestPositions(Order order) {
    Set<Position> positions = getTestPositions();
    positions.forEach(position -> position.setOrder(order));
    return positions;
  }

  public static Order getTestOrder() {
    return new Order("Grocery");
  }

  public static Order getTestOrder(Set<Position> positions) {
    return new Order("Grocery", positions);
  }

  /* iTunes objects */

  public static Artist getTestArtist() {
    return new Artist().setName("Metallica");
  }

  public static Album getTestAlbum() {
    return new Album()
        .setName("Reload")
        .setYear(1997)
        .setAlbumArtist("Metallica")
        .setCompilation(FALSE)
        .setTrackDiscInfo(Map.of(1, 13));
  }

  public static Album getTestAlbum(List<Track> tracks) {
    return getTestAlbum().setTracks(tracks);
  }

  public static Track getTestTrack() {
    return new Track()
        .setId("CB226CC410A85072")
        .setName("The Memory Remains")
        .setGenre("Rock")
        .setComposer("Ulrich, Hetfield")
        .setTrackNumber(2)
        .setDiscNumber(1)
        .setExplicit(FALSE)
        .setReleaseDate(LocalDateTime.of(1997, 11, 7, 12, 0));
  }

  public static List<Track> getTestTracks() {
    return Stream.of(
        List.of("Fuel", 1, 1, "3105EFEA81D2FA2C"),
        List.of("The Memory Remains", 2, 1, "CB226CC410A85072"),
        List.of("Devil's Dance", 3, 1, "508523580D5A51DB"),
        List.of("The Unforgiven II", 4, 1, "272E725E54380493"),
        List.of("Better than You", 5, 1, "DD3391F0C2640708"),
        List.of("Slither", 6, 1, "88AECD45DE6C0364"),
        List.of("Carpe Diem Baby", 7, 1, "DCE004861760FEFA"),
        List.of("Bad Seed", 8, 1, "148D5F28A6952DEC"),
        List.of("Where the Wild Things Are", 9, 1, "E87753388E8537E4"),
        List.of("Prince Charming", 10, 1, "504EC2248ED1AB5B"),
        List.of("Low Man's Lyric", 11, 1, "32241132896DD286"),
        List.of("Attitude", 12, 1, "E472613366E87969"),
        List.of("Fixxxer", 13, 1, "CCAFC969C7F125D9"))
        .map(track -> new Track()
            .setName((String) track.get(0))
            .setTrackNumber((Integer) track.get(1))
            .setDiscNumber((Integer) track.get(2))
            .setId((String) track.get(3)))
        .collect(Collectors.toList());
  }

  public static List<Track> getTestTracks(Album album) {
    List<Track> tracks = getTestTracks();
    tracks.forEach(track -> track.setAlbum(album));
    return tracks;
  }

}