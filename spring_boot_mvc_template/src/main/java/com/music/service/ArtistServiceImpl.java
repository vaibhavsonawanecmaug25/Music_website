package com.music.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dto.ArtistDto;
import com.music.model.Artist;
import com.music.repository.ArtistRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
	
	private  final ArtistRepository artistRepo;

	@Override
	public String createArtist(ArtistDto dto) {
		Artist a=new Artist();
		a.setName(dto.getName());
		a.setBio(dto.getBio());
		artistRepo.save(a);
		return "Artist created successfully...";
		
		
	}

	@Override
	public ArtistDto getArtistById(Long id) {
    Artist a=artistRepo.findById(id)
    		.orElseThrow(() -> new RuntimeException("Artist not found!!"));
    return converttoDto(a);
    
	}

	@Override
	public List<ArtistDto> getAllArtists() {
     return artistRepo.findAll().stream().map(this::converttoDto).collect(Collectors.toList());
     /*we have use converttodto to replace the repetition as we dont have to display every column in database
        as we would need to maintain some privacy so for that purpose we have used it*/
	}

	@Override
	public String updateArtist(Long id, ArtistDto dto) {
	    Artist a = artistRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Artist not found"));
      a.setName(dto.getName());
      a.setBio(dto.getBio());
      artistRepo.save(a);
      return "Artist updated sucessfully...";
	}

	@Override
	public String deleteArtist(Long id) {
     artistRepo.deleteById(id);
     return "Artist deleted sucessfully..";
	}
	private ArtistDto converttoDto(Artist a) {
        return new ArtistDto(
                a.getArtistId(),
                a.getName(),
                a.getBio()
        );
    }

	
	
	

}
