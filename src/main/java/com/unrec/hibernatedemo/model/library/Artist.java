package com.unrec.hibernatedemo.model.library;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ARTISTS")
public class Artist implements Serializable {

  @Id
  private String name;

  @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Album> albums;

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Artist)) {
      return false;
    }
    var other = (Artist) obj;
    return name != null && name.equals(other.getName());
  }
}