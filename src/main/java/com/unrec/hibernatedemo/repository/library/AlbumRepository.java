package com.unrec.hibernatedemo.repository.library;

import com.unrec.hibernatedemo.model.library.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

  @Transactional
  @Modifying
  @Query(value = "update ALBUMS a set a.name = :name, a.year = :year where a.id = :id", nativeQuery = true)
  void updateNameAndYearById(
      @Param("id") Integer id,
      @Param("name") String name,
      @Param("year") Integer year);
}
