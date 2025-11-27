package com.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.Song;
import com.music.repository.*;
import com.music.service.*;

import lombok.Getter;

@RestController
@RequestMapping("/songs")
public class SongController {
	@Autowired
	private SongService songService;
public SongController() {
	System.out.println("in ctor of "+ getClass());
}
	
	//get all songs
	//url: http://host:8080/songs
	@GetMapping
	
	public List<Song> getAllSongs(){
		System.out.println("Get all songs:-");
		return songService.getAllSongs();
		
	}
	//add new song
	//url:http://host:8080/songs
	
	@PostMapping
	public String addnewSong(@RequestBody Song song) {
		System.out.println("Add song "+ song);
		return songService.addSong(song);
		
	}
	 //Get songs by album ID
     // url - http://localhost:8080/songs/album/{albumId}
	@GetMapping("/album/{albumId}")
	public List<Song> getSongsByAlbumId(@PathVariable Long albumId){
		System.out.println("Get songs by album"+albumId);
		return songService.getSongsbyAlbumId(albumId);
	}
	//get song by artist
	//url:http://localhost:8080/songs/artist/{artistId}

    @GetMapping("/artist/{artistId}")
    public List<Song> getSongsByArtist(@PathVariable Long artistId) {
        System.out.println("in get songs by artist " + artistId);
        return songService.getSongsbyArtistId(artistId);
    }




	
	
	
	
	

}
