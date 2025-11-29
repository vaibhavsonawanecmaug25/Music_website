package com.music.repository;

import com.music.model.UserHistory;
import com.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    List<UserHistory> findByUserOrderByPlayedAtDesc(User user);

    List<UserHistory> findTop20ByUserOrderByPlayedAtDesc(User user);
}
