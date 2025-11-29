package com.music.service;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dto.SignupRequest;
import com.music.dto.UserDto;
import com.music.model.User;
import com.music.model.User_role;
import com.music.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


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
    private User toEntity(SignupRequest dto)
 {
        User u = new User();
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setPassword(passwordEncoder.encode(dto.getPassword())); //hash password
        u.setRole(User_role.USER);

        

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
    public UserDto addUser(SignupRequest signupreq) {
        User saved = userRepository.save(toEntity(signupreq));
        return toDto(saved);
    }

    @Override
    
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }


    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDto(user);
    }

	@Override
	public User getUserEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

	}
    
}
