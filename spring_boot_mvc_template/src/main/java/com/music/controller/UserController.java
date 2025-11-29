
	package com.music.controller;

	import com.music.dto.SignupRequest;
import com.music.dto.UserDto;
 import com.music.model.User;
	import com.music.service.UserService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;
	@CrossOrigin(origins = "http://localhost:5173")
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
	    public UserDto saveUser(@RequestBody SignupRequest signupReq) {
	        return userService.addUser(signupReq);
	    }

	    // DELETE USER
	    @DeleteMapping("/{id}")
	    public String deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	        return "User deleted successfully";
	    }
	    }


	    
	





