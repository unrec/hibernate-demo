package com.unrec.hibernatedemo.repository;


import com.unrec.hibernatedemo.model.library.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
