package com.music.service;
import java.util.List;

import com.music.dto.FavouritesongDto;


public interface UserFavouriteService {
List<FavouritesongDto> getFavouritesbyUserID(Long userId);
String addtoFavourites(Long userId,Long songId);
String removeFavourites(Long favId, Long songId);
boolean isSongFavourite(Long userId,Long songId);



}
