package com.sonata.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sonata.model.User;
import com.sonata.model.UserDto;
import com.sonata.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userser;
	
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/findAll")
	public List<User> getAll(User users) {
		logger.info("Fetching all products");
		return userser.getAllUser();
	}
	
	
	@GetMapping("/{userId}")
	public User  getUserDetails(@PathVariable int userId){
		logger.info("Fetching user details :{}" ,userId);
		return userser.getById(userId);
	}
	
	
	@PostMapping("/addNewUser")
	 public ResponseEntity<User> createUser(@RequestBody User user) {
	    User savedUser = userser.save(user);
	     return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	    }
	
	
	@GetMapping("/dto/{userId}")
	public ResponseEntity<UserDto> getUserDetails1(@PathVariable int userId) {
	    User user = userser.getById(userId);

	    if (user != null) {
	        UserDto userDto = new UserDto();
	        userDto.setUserId(user.getUserId());
	        userDto.setUserName(user.getUserName());
	        userDto.setPhoneNumber(user.getPhoneNumber());
	        userDto.setEmail(user.getEmail());

	        return ResponseEntity.ok(userDto);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
	  @PutMapping("/{userId}")
	    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
	        updatedUser.setUserId(userId);
	        
	        User updatedUserData = userser.updateUser(updatedUser);

	        if (updatedUserData != null) {
	            return ResponseEntity.ok(updatedUserData);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	        
	        
	    }
	  
	  
	  @DeleteMapping("/{uId}")
	    public ResponseEntity<String> deleteUser(@PathVariable int uId) {
	        boolean deleted = userser.deleteUser(uId);

	        if (deleted) {
	            return ResponseEntity.ok("User deleted successfully");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	
	
	
	

}
