package com.music.service;

import com.music.model.User;
import com.music.model.Song;
import com.music.model.UserHistory;
import com.music.repository.UserHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

    private final UserHistoryRepository historyRepo;

    public UserHistoryServiceImpl(UserHistoryRepository historyRepo) {
        this.historyRepo = historyRepo;
    }

    @Override
    public void addToHistory(User user, Song song) {
        UserHistory history = new UserHistory(user, song, LocalDateTime.now());
        historyRepo.save(history);
    }

    @Override
    public List<Song> getUserHistory(User user) {
        return historyRepo.findTop20ByUserOrderByPlayedAtDesc(user)
                .stream()
                .map(UserHistory::getSong)
                .collect(Collectors.toList());
    }
}
