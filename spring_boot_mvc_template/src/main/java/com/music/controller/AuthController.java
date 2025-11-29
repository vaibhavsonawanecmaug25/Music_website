package com.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.music.dto.LoginRequest;
import com.music.dto.LoginResponse;
import com.music.model.User;
import com.music.repository.UserRepository;
import com.music.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest login) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getEmail(), login.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(login.getEmail());
        User user = userRepository.findByEmail(login.getEmail()).get();

        String role = user.getRole().name();
        String token = jwtTokenProvider.generateToken(userDetails, role);

        return new LoginResponse(
                token,
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
