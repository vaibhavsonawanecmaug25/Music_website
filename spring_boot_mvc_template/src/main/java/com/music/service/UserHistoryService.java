package com.music.service;

import com.music.model.User;
import com.music.model.Song;
import java.util.List;

public interface UserHistoryService {

    void addToHistory(User user, Song song);

    List<Song> getUserHistory(User user);
}
