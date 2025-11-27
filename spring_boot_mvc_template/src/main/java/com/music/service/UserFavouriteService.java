package com.music.service;
import java.util.List;

import com.music.model.UserFavourite;

public interface UserFavouriteService {
List<UserFavourite> getFavouritesbyUserID(Long userId);
String addtoFavourites(Long userId,Long songId);
String removeFavourites(Long favId);
boolean isSongFavourite(Long userId,Long songId);



}
