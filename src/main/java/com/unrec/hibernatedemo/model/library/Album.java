package com.unrec.hibernatedemo.model.library;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ALBUMS")
public class Album implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(FetchMode.JOIN)
  private List<Track> tracks;

  @Column
  private String name;
  @Column
  private Integer year;
  @Column
  private String albumArtist;
  @Column
  private Boolean compilation;

  @Column
  @ElementCollection
  @Fetch(FetchMode.JOIN)
  private Map<Integer, Integer> trackDiscInfo;

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Album)) {
      return false;
    }
    var other = (Album) obj;
    return id != null && id.equals(other.getId());
  }
}