package com.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.dto.ArtistDto;
import com.music.service.ArtistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping
    public String createArtist(@RequestBody ArtistDto dto) {
        return artistService.createArtist(dto);
    }

    @GetMapping
    public List<ArtistDto> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ArtistDto getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id);
    }

    @PutMapping("/{id}")
    public String updateArtist(@PathVariable Long id, @RequestBody ArtistDto dto) {
        return artistService.updateArtist(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteArtist(@PathVariable Long id) {
        return artistService.deleteArtist(id);
    }
}

