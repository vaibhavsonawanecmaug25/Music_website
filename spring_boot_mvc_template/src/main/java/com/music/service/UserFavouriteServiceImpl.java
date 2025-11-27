package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.Song;
import com.music.model.User;
import com.music.model.UserFavourite;
import com.music.repository.SongRepository;
import com.music.repository.UserFavouriteRepository;
import com.music.repository.UserRepository;

@Service
public class UserFavouriteServiceImpl implements UserFavouriteService{
	@Autowired
	private UserFavouriteRepository favRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SongRepository songRepo;
	@Override
	public List<UserFavourite> getFavouritesbyUserID(Long userId) {
		// TODO Auto-generated method stub
		return favRepo.findByUserUserId(userId);
		
	}
	@Override
	public String addtoFavourites(Long userId, Long songId) {
		if(favRepo.existsByUserUserIdAndSongSongId(userId, songId)) {
			return "Song is already listed in favourites...";
		
		}
		User user=userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Invalid User"));
		Song song = songRepo.findById(songId).orElseThrow(() -> new RuntimeException("Invalid Song"));
          UserFavourite fav=new UserFavourite(user,song);
          favRepo.save(fav);
          return "Song added to favourites....";
          
	}
	@Override
	public String removeFavourites(Long favId) {
		// TODO Auto-generated method stub
		if(favRepo.existsById(favId)) {
			favRepo.deleteById(favId);
			return "Song removed from favourites";
		}
		return "Song doesn't exist in favourites";
		
	}
	@Override
	public boolean isSongFavourite(Long userId, Long songId) {
		// TODO Auto-generated method stub
		return favRepo.existsByUserUserIdAndSongSongId(userId, songId);
	}
	
	
	
	
	
	

	
}
