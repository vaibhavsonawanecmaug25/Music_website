package com.music.repository;

import com.music.model.UserFavourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavouriteRepository extends JpaRepository<UserFavourite, Long> {

    // fetch favourites by user
    List<UserFavourite> findByUserUserId(Long userId);

    // check if already favourited
    boolean existsByUserUserIdAndSongSongId(Long userId, Long songId);

    // fetch specific favourite
    List<UserFavourite> findByUserUserIdAndSongSongId(Long userId, Long songId);
}
