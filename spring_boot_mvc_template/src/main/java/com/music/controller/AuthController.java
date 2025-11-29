//package com.music.controller;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//	@RequestMapping("/auth")
//	public class AuthController {
//
//	    @Autowired
//	    private AuthenticationManager authManager;
//
//	    @Autowired
//	    private JwtUtil jwtUtil;
//
//	    @PostMapping("/login")
//	    public ResponseEntity<?> login(@RequestBody LoginDto request) {
//
//	        Authentication auth = authManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//	        );
//
//	        String token = jwtUtil.generateToken(request.getEmail());
//
//	        return ResponseEntity.ok(new TokenResponse(token));
//	    }
//	}
//
//
//}
