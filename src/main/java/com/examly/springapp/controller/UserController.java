package com.examly.springapp.controller;
import com.examly.springapp.services.UserService;
import com.examly.springapp.repo.userRepo;
import com.examly.springapp.model.UserModel;
import java.util.*;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
		this.userService = userService;
	}
     

    @GetMapping("/admin/active")
    public List<UserModel> getOnlineUser(){
        List<UserModel> userList = userService.getOnlineUsers();
        return userList;
    }

    @GetMapping("/admin")
    public List<UserModel> getAllUsers(){
        List<UserModel> userList = userService.getUsers();
        return userList;
    }

    @GetMapping("/admin/{id}")
    public UserModel userEditData(@PathVariable(value="id") String id){
        UserModel user = userService.findById(id);
        return user;
    }


    @PutMapping("/admin/userEdit/{id}")
    public UserModel userUpdate(@RequestBody UserModel user, @PathVariable String id){
        UserModel userM = userService.findById(id);
        user.setId(id);
        if(userM!=null){
        userM = userService.updateUser(user);
        }
        return userM;
    }

    @DeleteMapping("/admin/delete/{id}")
    public void userDelete(@PathVariable String id){
        userService.deleteUser(id);
    }

    @PostMapping("/admin/addUser")
	public UserModel addUser(@RequestBody UserModel user){
		if(userService.findByEmail(user.getEmail()) == null){
			userService.saveUser(user);
			return user;
		}
		return null;
	}

}
