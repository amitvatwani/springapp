package com.examly.springapp.controller;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SignupController {
    private final UserService userService;
	
	public SignupController(UserService userService) {
		this.userService = userService;
	}
    
    @PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean saveUser(@RequestBody UserModel user){
		try{
		if(userService.findByEmail(user.getEmail()) == null){
			userService.saveUser(user);
			return true;
		}
		else{
			return false;
		}
	}
	catch(Exception e){
		return false;
	}
		
	}

}
