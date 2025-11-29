package com.music.service;

import java.util.List;

import com.music.dto.SignupRequest;
import com.music.dto.UserDto;
import com.music.model.User;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto addUser(SignupRequest signupRequest);

    void deleteUser(Long id);
    User getUserEntityById(Long id);
    UserDto getUserById(Long id);
}
