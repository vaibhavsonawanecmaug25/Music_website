package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.Album;
import com.music.repository.AlbumRepository;

@Service
public class AlbumServiceImpl  implements AlbumService{
    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }


}
