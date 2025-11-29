package com.music.controller;

import com.music.model.Album;
import com.music.service.AlbumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    // LIST
    @GetMapping
    public List<Album> listAlbums() {
        return albumService.getAllAlbums();
    }

    // SAVE
    @PostMapping
    public Album saveAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

    // DELETE
    @DeleteMapping("/{albumId}")
    public String deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbumById(albumId);
        return "Album Deleted Successfully";
    }

    // VIEW
    @GetMapping("/{albumId}")
    public Album viewAlbum(@PathVariable Long albumId) {
        return albumService.getAlbumById(albumId);
    }
}
