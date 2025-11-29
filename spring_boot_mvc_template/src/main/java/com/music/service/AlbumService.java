package com.music.service;
	import com.music.model.Album;
	import java.util.List;

	public interface AlbumService {

	    List<Album> getAllAlbums();
	    Album saveAlbum(Album album);
	    void deleteAlbumById(Long id);
	    Album getAlbumById(Long id);
	}


