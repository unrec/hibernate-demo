package com.unrec.hibernatedemo.repository;

import com.unrec.hibernatedemo.model.library.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {

}
