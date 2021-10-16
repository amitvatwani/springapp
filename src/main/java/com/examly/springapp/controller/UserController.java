package com.examly.springapp.controller;
import java.util.List;
import com.examly.springapp.dto.GenericResponse;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
		this.userService = userService;
	}
     
    //Get all online users
    @GetMapping("/admin/active")
    public List<UserModel> getOnlineUser(){
        List<UserModel> userList = userService.getOnlineUsers();
        return userList;
    }

    //Get all users
    @GetMapping("/admin")
    public List<UserModel> getAllUsers(){
        List<UserModel> userList = userService.getUsers();
        return userList;
    }

    //find user from db
    @GetMapping("/admin/{id}")
    public UserModel userEditData(@PathVariable(value="id") String id){
        UserModel user = userService.findById(id);
        return user;
    }

    //Edit user data
    @PutMapping("/admin/userEdit/{id}")
    public UserModel userUpdate(@RequestBody UserModel user, @PathVariable String id){
        UserModel userM = userService.findById(id);
        user.setId(id);
        if(userM!=null){
        userM = userService.updateUser(user);
        }
        return userM;
    }

    //Delete user
    @DeleteMapping("/admin/delete/{id}")
    public void userDelete(@PathVariable String id){
        userService.deleteUser(id);
    }

    //Add user in db
    @PostMapping("/admin/addUser")
	public GenericResponse<Boolean> addUser(@RequestBody UserModel user){
        GenericResponse<Boolean> response = new GenericResponse<>();
		if(userService.findByEmail(user.getEmail()) == null){
			userService.saveUser(user);
			response.setResponse(true);
		}
        response.setResponse(false);
		return response;
	}

    //Logout user (Setting active as false)
    @PostMapping("/logout/{id}")
	public boolean userLogout(@PathVariable String id){
        UserModel user = userService.findById(id);
        if(user!=null){
		    userService.setLoginStatusAsFalse(id);
            return true;
        }
        else
        {
            return false;
        }
	}

}
