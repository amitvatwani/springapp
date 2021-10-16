package com.examly.springapp.controller;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
    private final UserService userService;
    public LoginController(UserService userService) {
		this.userService = userService;
	}
    //Login Api
    @PostMapping("/login")
    public ResponseEntity<UserModel> checkUser(@RequestBody LoginModel loginUser){
        try{  
        //If user is not registered
		if(userService.findByEmail(loginUser.getEmail())==null){
            HashMap<String, String> map1 = new HashMap<String, String>();
            map1.put("message", "User does not exists");
            return new ResponseEntity(map1, HttpStatus.BAD_REQUEST);
        }
        else{
            //Processing Login Request

            //Getting user email passed from frontend
            String requestingUserEmail = loginUser.getEmail();

            //Getting user password passed from frontend
            String requestingUserPassword = loginUser.getPassword();

            //Validating credentials of frontend and database
            if((userService.findByEmail(requestingUserEmail).getPassword()).equals(requestingUserPassword)){
                userService.setLoginStatusAsTrue(loginUser.getEmail()); 
                UserModel user = userService.findByEmail(loginUser.getEmail());
                return new ResponseEntity<UserModel>(user,HttpStatus.OK);
            }

            //If entered password is incorrect
            else{
                HashMap<String, String> map1 = new HashMap<String, String>();
                map1.put("message", "Incorrect Password");
                return new ResponseEntity(map1, HttpStatus.BAD_REQUEST);
            }
        }
    }
    catch(Exception e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    }

}
