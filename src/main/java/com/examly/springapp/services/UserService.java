package com.examly.springapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.repo.userRepo;

import java.security.cert.CertPathValidatorException.Reason;
import java.util.*;
import com.examly.springapp.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@Service
public class UserService {
    private final userRepo userRepo;

    @Autowired
	public UserService(userRepo userRepo) {
		
		this.userRepo = userRepo;
	}

	public UserModel findByEmail(String email){
		UserModel user = userRepo.findUserModelByEmail(email).orElse(null);
		return user;
	}

    public UserModel saveUser(UserModel user) {
			UserModel newUser = userRepo.save(user);
			return newUser;
	}

	public List<UserModel> getUsers(){
		List<UserModel> userList = userRepo.findAll();
		return userList;
	}
	
	public void setLoginStatusAsTrue(String email){
		UserModel user = findByEmail(email);
		user.setActive(true);
		userRepo.save(user);
	}
	
	public List<UserModel> getOnlineUsers(){
		List<UserModel> userList = userRepo.findUserModelByActive(true).orElse(null);
		return userList;
	}
	public UserModel findById(String id){
		UserModel user = userRepo.findUserModelById(id).orElse(null);
		return user;
	}

	public UserModel updateUser(UserModel userModel){
		return userRepo.save(userModel);
	}

	public void deleteUser(String id){
		userRepo.deleteById(id);
	}

}
