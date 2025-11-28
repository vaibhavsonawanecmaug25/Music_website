package com.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.music.dto.FavouritesongDto;
import com.music.model.UserFavourite;
import com.music.service.UserFavouriteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/favourites")
@Tag(name = "Favourite Songs API", description = "Operations for managing user's favourite songs")
public class UserFavouriteController {

    @Autowired
    private UserFavouriteService favService;

    public UserFavouriteController() {
        System.out.println("in ctor of " + getClass());
    }

    // ---------------------------------------------------------
    // Get all favourites of a user
    // URL: GET http://localhost:8080/favourites/user/1
    // ---------------------------------------------------------
    @Operation(summary = "Get favourite songs of a user")
    @GetMapping("/user/{userId}")
    public List<FavouritesongDto> getUserFavourites(@PathVariable Long userId) {
        System.out.println("Get favourites for user: " + userId);
        return favService.getFavouritesbyUserID(userId);
    }


    // Add song to favourites
    // url: POST http://localhost:8080/favourites/add?userId=1&songId=10
    
    @Operation(summary = "Add a song to user's favourites")
    @PostMapping("/add")
    public String addFavourite(@RequestParam Long userId, @RequestParam Long songId) {
        System.out.println("Add favourite: user=" + userId + ", song=" + songId);
        return favService.addtoFavourites(userId, songId);
    }

    
    // Remove song from favourites
    // url: http://localhost:8080/favourites/remove?userId=1&songId=10
    
    @Operation(summary = "Remove a song from user's favourites")
    @DeleteMapping("/remove")
    public String removeFavourite(@RequestParam Long userId, @RequestParam Long songId) {
        System.out.println("Remove favourite: user=" + userId + ", song=" + songId);
        return favService.removeFavourites(userId, songId);
    }

    //
    //if song is in favourites
    // url: GET http://localhost:8080/favourites/check?userId=1&songId=10
    
    @Operation(summary = "Check if a song is already in favourites")
    @GetMapping("/check")
    public boolean isFavourite(@RequestParam Long userId, @RequestParam Long songId) {
        System.out.println("Check favourite: user=" + userId + ", song=" + songId);
        return favService.isSongFavourite(userId, songId);
    }
}
