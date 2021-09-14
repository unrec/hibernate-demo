package com.unrec.hibernatedemo.model.library;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "TRACKS")
public class Track implements Serializable {

  @Id
  private String id;
  @ManyToOne
  @JoinColumn(name = "album_id")
  private Album album;
  @Column
  private String name;
  @Column
  private String genre;
  @Column
  private String composer;
  @Column
  private Integer trackNumber;
  @Column
  private Integer discNumber;
  @Column
  private Boolean explicit;
  @Column
  private LocalDateTime releaseDate;
  /* File properties */
  @Column
  private URL location;
  @Column
  private Long size;
  @Column
  private String kind;
  @Column
  private Integer bitRate;
  @Column
  private Integer sampleRate;
  @Column
  private Integer bpm;
  @Column
  private String comments;
  /* Library-related properties */
  @Column
  private Integer trackId;
  @Column
  private Integer playCount;
  @Column
  private Integer skipCount;
  @Column
  private Integer rating;
  @Column
  private LocalDateTime dateAdded;
  @Column
  private LocalDateTime dateModified;
  @Column
  private LocalDateTime playDateUTC;
  @Column
  private LocalDateTime skipDate;
  @Column
  private Boolean purchased;
  @Column
  private String trackType;

  public Track() {
  }

  @Override
  public int hashCode() {
    return 42;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Track other = (Track) obj;
    if (id == null) {
      return false;
    } else {
      return id.equals(other.getId());
    }
  }
}