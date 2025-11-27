package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.music.controller.UserFavouriteController;
import com.music.model.Album;
import com.music.model.Song;
import com.music.repository.SongRepository;

@Service
public class SongService {

    private final UserFavouriteController userFavouriteController;
	@Autowired
private SongRepository songRepo;

    SongService(UserFavouriteController userFavouriteController) {
        this.userFavouriteController = userFavouriteController;
    }
	public List<Song> getAllSongs(){
		return songRepo.findAll();
	}
	public String addSong(Song song) {
		songRepo.save(song);
		return "Song saved sucessfully......";
		
		
	}
	public List<Song> getSongsbyAlbumId(Long albumId){
		return songRepo.findByAlbumAlbumId(albumId);
		
	}
	public List<Song> getSongsbyArtistId(Long artistId){
		return songRepo.findByArtistArtistId(artistId);

}
	
	
	
	
	
	
}
