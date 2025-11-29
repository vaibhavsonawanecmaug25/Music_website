package com.music.service;

import java.util.List;

import com.music.dto.UserDto;
import com.music.model.User;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto addUser(UserDto user);
    void deleteUser(Long id);
    UserDto getUserById(Long id);
}
