package com.music.controller;

import com.music.model.UserFavourite;
import com.music.model.User;
import com.music.model.Song;
import com.music.repository.UserFavouriteRepository;
import com.music.repository.UserRepository;
import com.music.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/favourites")   // Base URL like /favourites/*
public class UserFavouriteController {

    @Autowired
    private UserFavouriteRepository favouriteRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SongRepository songRepo;

    public UserFavouriteController() {
        System.out.println("in ctor of " + getClass());
    }

    
     // ALL FAVOURITE SONGS by id
    // URL: /favourites/list?userId=1
    // VIEW : /WEB-INF/views/favourites/list.jsp

    @GetMapping("/list")
    public String listUserFavourites(@RequestParam Long userId, Model model) {

        System.out.println("Fetching favourites for user: " + userId);

        List<UserFavourite> favList = favouriteRepo.findByUserUserId(userId);

        model.addAttribute("fav_list", favList);
        model.addAttribute("userId", userId);

        return "favourites/list"; // JSP page
    }

    // --------------------------------------------------------------------
    // SHOW ADD FAVOURITE FORM
    // URL → /favourites/add?userId=1
    // VIEW → favourites/add.jsp
    // --------------------------------------------------------------------
    @GetMapping("/add")
    public String showAddFavouriteForm(@RequestParam Long userId, Model model) {

        model.addAttribute("songs", songRepo.findAll());
        model.addAttribute("userId", userId);

        return "favourites/add";
    }

    // --------------------------------------------------------------------
    //ADD FAVOURITE FORM SUBMISSION
    // URL : /favourites/add  (POST)
    
    @PostMapping("/add")
    public String addFavourite(@RequestParam Long userId,
                               @RequestParam Long songId,
                               Model model) {

        boolean exists = favouriteRepo.existsByUserUserIdAndSongSongId(userId, songId);

        if (exists) {
            model.addAttribute("message", "Song already in favourites!");
            return "redirect:/favourites/list?userId=" + userId;
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Song song = songRepo.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        UserFavourite fav = UserFavourite.builder()
                .user(user)
                .song(song)
                .build();

        favouriteRepo.save(fav);

        return "redirect:/favourites/list?userId=" + userId;
    }

    
    // delete from favopurites
    @GetMapping("/remove")
    public String removeFavourite(@RequestParam Long userId,
                                  @RequestParam Long songId,
                                  Model model) {

        List<UserFavourite> list = favouriteRepo.findByUserUserIdAndSongSongId(userId, songId);

        if (!list.isEmpty()) {
            favouriteRepo.deleteAll(list);
        }

        return "redirect:/favourites/list?userId=" + userId;
    }
}
