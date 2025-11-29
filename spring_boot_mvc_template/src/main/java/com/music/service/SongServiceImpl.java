package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.music.dto.SongalbumDto;
import com.music.model.Song;
import com.music.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

    
	@Autowired
private SongRepository songRepo;
	//get all songs
	@Override
	public List<Song> getAllSongs() {
	return songRepo.findAll();
	}
	//add song
	@Override
	public String addSong(Song song) {
		songRepo.save(song);
		return "Song saved Sucessfully...";
	}
				
	//getsong by album
	@Override
	public List<SongalbumDto> getSongsByAlbumId(Long albumId) {
         List<Song> songs=songRepo.findByAlbumAlbumId(albumId);
         return songs.stream()
        		 .map(s ->new SongalbumDto(
        			s.getSongId(),
        			s.getTitle(),
        			s.getArtist().getName(),
        			s.getGenre(),
        			s.getDuration(),
        			s.getAudioUrl())).toList();
	}
	//getsong by artist
	@Override
	public List<SongalbumDto> getSongsByArtistId(Long artistId) {
		// TODO Auto-generated method stub
		List<Song> songs=songRepo.findByArtistArtistId(artistId);
		return songs.stream()
				.map(s ->new SongalbumDto(
						s.getSongId(),
						s.getTitle(),
						s.getArtist().getName(),
						s.getGenre(),
						s.getDuration(),
						s.getAudioUrl())).toList();
	}
	
	//delete song
	@Override
	public String deleteSong(Long songId) {
		if(!songRepo.existsById(songId)) {
			return "Song not found!!";
		}
		   songRepo.deleteById(songId);

	        return "Song deleted successfully...";
	}
	//get song by id
	@Override
	public SongalbumDto getSongById(Long id) {
		// TODO Auto-generated method stub
		return songRepo.findById(id)
				.stream().map(s -> new SongalbumDto(
						s.getSongId(),
						s.getTitle(),
						
						s.getArtist().getName(),
						s.getGenre(),
						s.getDuration(),
						s.getAudioUrl()))
				       .findFirst()
				
				.orElseThrow(() -> new RuntimeException("Song not found"));
	}
	@Override
	public Song getSongEntityById(Long songId) {
	    return songRepo.findById(songId)
		        .orElseThrow(() -> new RuntimeException("Song not found"));

	}
	
	
	
	}
	
	

	

    