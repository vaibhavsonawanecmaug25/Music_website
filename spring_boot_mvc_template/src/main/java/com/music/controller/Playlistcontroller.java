package com.music.controller;
import com.music.repository.ArtistRepository;
import com.music.service.Playlistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.music.dto.PlaylistsDto;

@RestController
@RequestMapping("/playlists")
public class Playlistcontroller {
	@Autowired
	private Playlistservice playlistserv;

    
    
	@PostMapping
	public String createPlaylist(@RequestBody PlaylistsDto pdto) {
		System.out.println("Creating playlist"+pdto);
		return playlistserv.createPlaylist(pdto);
	}
	@GetMapping("/{id}")
	public PlaylistsDto getPlaylistById(@PathVariable Long id){
		System.out.println("Fetching playlist by id:"+id);
		return playlistserv.getPlaylist(id);
	}
	@GetMapping
	public List<PlaylistsDto> getAllPlaylist(){
		System.out.println("Fetching all playlist...");
		return playlistserv.getAll();
	}
	@DeleteMapping("/{id}")
	public String deletePlaylist(@PathVariable Long id) {
		
		System.out.println("Deleting playlist: "+id);
		return playlistserv.deletePlaylist(id);
	}
	
	
	

}
