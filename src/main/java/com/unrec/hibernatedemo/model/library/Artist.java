package com.unrec.hibernatedemo.model.library;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ARTISTS")
public class Artist implements Serializable {
    @Id
    private String name;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Album> albums;

    public Artist() {
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artist other = (Artist) obj;
        if (name == null) {
            return false;
        } else return name.equals(other.getName());
    }
}