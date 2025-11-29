
	package com.music.controller;

	import com.music.dto.UserDto;
 import com.music.model.User;
	import com.music.service.UserService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/api/users")
   public class UserController{

	    @Autowired
	    private UserService userService;
	    

	    // LIST
	    @GetMapping
	    public List<UserDto> listUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping("/{id}")
	    public UserDto getUser(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }

	    @PostMapping
	    public UserDto saveUser(@RequestBody UserDto dto) {
	        return userService.addUser(dto);
	    }

	    }
	





