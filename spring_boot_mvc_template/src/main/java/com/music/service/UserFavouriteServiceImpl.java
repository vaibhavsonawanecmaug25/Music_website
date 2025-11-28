package com.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dto.FavouritesongDto;
import com.music.model.Song;
import com.music.model.User;
import com.music.model.UserFavourite;
import com.music.repository.SongRepository;
import com.music.repository.UserFavouriteRepository;
import com.music.repository.UserRepository;

@Service
public class UserFavouriteServiceImpl implements UserFavouriteService {

    @Autowired
    private UserFavouriteRepository favRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SongRepository songRepo;

    @Override
    public List<FavouritesongDto> getFavouritesbyUserID(Long userId) {
        List<UserFavourite> fav=favRepo.findByUserUserId(userId);
        return fav.stream()
        		.map(favs -> new FavouritesongDto(
        				favs.getSong().getSongId(),
        				favs.getSong().getTitle(),
        				favs.getSong().getArtist().getName())).toList();
    }

    @Override
    public String addtoFavourites(Long userId, Long songId) {

        if (favRepo.existsByUserUserIdAndSongSongId(userId, songId)) {
            return "Song is already listed in favourites...";
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Invalid User"));

        Song song = songRepo.findById(songId)
                .orElseThrow(() -> new RuntimeException("Invalid Song"));

        UserFavourite fav = new UserFavourite(user, song);
        favRepo.save(fav);

        return "Song added to favourites....";
    }

    @Override
    public String removeFavourites(Long userId, Long songId) {

        List<UserFavourite> favList =
                favRepo.findByUserUserIdAndSongSongId(userId, songId);

        if (favList.isEmpty()) {
            return "Song doesn't exist in favourites";
        }

        favRepo.deleteAll(favList);

        return "Song removed from favourites";
    }

	@Override
	public boolean isSongFavourite(Long userId, Long songId) {
		return favRepo.existsByUserUserIdAndSongSongId(userId, songId);

	}
}

    
