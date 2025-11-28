package com.music.repository;

import com.music.model.PlaylistSong;
import com.music.model.Playlist;
import com.music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaylistsongRepository extends JpaRepository<PlaylistSong, Long> {

    // Get all songs inside a playlist
    List<PlaylistSong> findByPlaylist(Playlist playlist);

    // Check if a song already exists in a playlist
    Optional<PlaylistSong> findByPlaylistAndSong(Playlist playlist, Song song);

    // Delete all songs in a playlist
    void deleteByPlaylist(Playlist playlist);
}
