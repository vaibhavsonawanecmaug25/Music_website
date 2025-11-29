package com.music.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.music.dto.SongalbumDto;
import com.music.model.Song;

public interface SongService {
    List<Song> getAllSongs();
    String addSong(Song song);

    List<SongalbumDto> getSongsByAlbumId(Long albumId);
    List<SongalbumDto> getSongsByArtistId(Long artistId);
    String deleteSong(Long songId);
    SongalbumDto getSongById(Long id);
	Song getSongEntityById(Long songId);
    


}