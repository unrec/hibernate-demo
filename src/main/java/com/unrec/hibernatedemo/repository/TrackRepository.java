package com.unrec.hibernatedemo.repository;

import com.unrec.hibernatedemo.model.library.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, String> {

}
