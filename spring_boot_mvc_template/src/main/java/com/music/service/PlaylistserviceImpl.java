package com.music.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dto.PlaylistsDto;
import com.music.model.Playlist;
import com.music.model.PlaylistSong;
import com.music.model.Song;
import com.music.model.User;
import com.music.repository.PlaylistRepository;
import com.music.repository.PlaylistsongRepository;
import com.music.repository.SongRepository;
import com.music.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PlaylistserviceImpl implements Playlistservice {

    @Autowired
    private PlaylistRepository playlistRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SongRepository songRepo;

    @Autowired
    private PlaylistsongRepository playlistSongRepo;
	@Override
	public String createPlaylist(PlaylistsDto dto) {
		Playlist p1=new Playlist();
		p1.setName(dto.getName());
		p1.setCreatedAt(LocalDateTime.now());
		User user=userRepo.findById(dto.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));
		p1.setUser(user);

        playlistRepo.save(p1); // fisrt save the playlist
// adding songs using join table
        if(dto.getSongId() !=null) {
        	for(Long songId:dto.getSongId()) {
        		Song song=songRepo.findById(songId)
        				.orElseThrow(() -> new RuntimeException("Song not found !!!"));
        		PlaylistSong ps=new PlaylistSong();
        		ps.setPlaylist(p1);
        		ps.setSong(song);
        		playlistSongRepo.save(ps);
        	}
        }
        return "Playlist created sucessfully....";

	}
	
	//get playlist by id
	@Transactional
	@Override
	public PlaylistsDto getPlaylist(Long id) {
     Playlist p=playlistRepo.findById(id)
    		 .orElseThrow(() -> new RuntimeException("Playlist not found"));
    		 return convertToDto(p);
	}
	//get all playlist
	@Transactional
	@Override
	public List<PlaylistsDto> getAll() {
		List<Playlist> list=playlistRepo.findAll();
	     return list.stream()
	    		 .map(this::convertToDto).collect(Collectors.toList());
	}
	//delete playlist
	@Override
	public String deletePlaylist(Long id) {
		playlistRepo.deleteById(id);
        return "Playlist deleted successfully";
	}
        
        
        //converting to Dto
	
	private PlaylistsDto convertToDto(Playlist p) {

	    List<String> songNames = p.getPlaylistSongs()
	            .stream()
	            .map(ps -> ps.getSong().getTitle())
	            .collect(Collectors.toList());

	    return new PlaylistsDto(
	            p.getPlaylistId(),             // 1
	            p.getName(),                   // 2
	            p.getUser().getUserId(),       // 3
	            p.getCreatedAt(),              // 4
	            null,                          // 5 -> songId (POST only)
	            songNames                      // 6 -> songName (GET)
	    );
	}
	
}
        

	
	
	
	
 
 

