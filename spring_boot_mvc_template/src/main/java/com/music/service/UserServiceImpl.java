package com.music.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.music.dto.UserDto;
import com.music.model.User;
import com.music.model.User_role;
import com.music.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Convert Entity -> DTO
    private UserDto toDto(User u) {
        UserDto dto = new UserDto();
        dto.setId(u.getUserId());
        dto.setName(u.getName());
        dto.setEmail(u.getEmail());
        dto.setRole(u.getRole().name());
        return dto;
    }

    // Convert DTO -> Entity
    private User toEntity(UserDto dto) {
        User u = new User();
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword()); // you will hash later
        if (dto.getRole() == null || dto.getRole().isEmpty()) {
            u.setRole(User_role.USER);   // DEFAULT ROLE
        } else {
            try {
                u.setRole(User_role.valueOf(dto.getRole().toUpperCase()));
            } catch (IllegalArgumentException e) {
                u.setRole(User_role.USER); // If invalid → default USER
            }
        }

        return u;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User saved = userRepository.save(toEntity(userDto));
        return toDto(saved);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDto(user);
    }
}
