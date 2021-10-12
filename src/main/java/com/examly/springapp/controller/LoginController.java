package com.examly.springapp.controller;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
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
            return new ResponseEntity("User does not exists", HttpStatus.BAD_REQUEST);
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
                return new ResponseEntity("Incorrect Password", HttpStatus.BAD_REQUEST);
            }
        }
    }
    catch(Exception e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    }

}
