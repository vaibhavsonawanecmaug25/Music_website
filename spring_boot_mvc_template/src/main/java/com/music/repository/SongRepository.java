package com.music.repository;

import com.music.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    
    Page<Song> findByGenre(String genre, Pageable pageable);
    
    List<Song> findByArtistArtistId(Long artistId);
    List<Song> findByAlbumAlbumId(Long albumId);
    
    
    @Query("SELECT s FROM Song s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :query, '%')) " +
           "OR LOWER(s.artist.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
           "OR LOWER(s.genre) LIKE LOWER(CONCAT('%', :query, '%'))")
    Page<Song> searchSongs(@Param("query") String query, Pageable pageable);
    
    
}