package com.music.controller;

import com.music.model.Song;
import com.music.model.User;
import com.music.service.UserHistoryService;
import com.music.service.SongService;
import com.music.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin
public class UserHistoryController {

    private final UserHistoryService historyService;
    private final UserService userService;
    private final SongService songService;

    public UserHistoryController(UserHistoryService historyService, UserService userService, SongService songService) {
        this.historyService = historyService;
        this.userService = userService;
        this.songService = songService;
    }

    @PostMapping("/add")
    public String addHistory(@RequestParam Long userId,
                             @RequestParam Long songId) {

        User user = userService.getUserEntityById(userId);
        Song song = songService.getSongEntityById(songId);

        historyService.addToHistory(user, song);

        return "Song added to history";
    }

    @GetMapping("/{userId}")
    public List<Song> getHistory(@PathVariable Long userId) {
        User user = userService.getUserEntityById(userId);
        return historyService.getUserHistory(user);
    }
}
