package com.music.repository;

import com.music.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    
	List<Album> findByArtistArtistId(Long artistId);

}