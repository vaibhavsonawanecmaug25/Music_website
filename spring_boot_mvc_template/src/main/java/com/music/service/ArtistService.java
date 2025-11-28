package com.music.service;

    import com.music.dto.ArtistDto;
	import java.util.List;
	
	
	public interface ArtistService {
        String createArtist(ArtistDto dto);
         ArtistDto getArtistById(Long id);
        List<ArtistDto> getAllArtists();
	    String updateArtist(Long id, ArtistDto dto);
        String deleteArtist(Long id);
	}


