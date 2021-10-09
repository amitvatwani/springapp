package com.examly.springapp.controller;
import com.examly.springapp.services.UserService;
import com.examly.springapp.repo.userRepo;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.model.LoginModel;
import java.util.*;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class LoginController {
    private final UserService userService;
    public LoginController(UserService userService) {
		this.userService = userService;
	}
    @PostMapping("/login")
    public boolean checkUser(@RequestBody LoginModel loginUser){
        try{
		if(userService.findByEmail(loginUser.getEmail())==null){
            return false;
        }
        else{
            if((userService.findByEmail(loginUser.getEmail()).getPassword()).equals(loginUser.getPassword())){
                userService.setLoginStatusAsTrue(loginUser.getEmail());
                return true;
            }
            else{
                return false;
            }
        }
    }
    catch(Exception e){
        return false;
    }
    }

}
