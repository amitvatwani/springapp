package com.examly.springapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.repo.userRepo;
import com.examly.springapp.repo.musicRepo;
import java.security.cert.CertPathValidatorException.Reason;
import java.util.*;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.model.MusicModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@Service
public class LikeService {
    private final likeRepo likeRepo;

    @Autowired
	public LikeService(likeRepo likeRepo) {
		
		this.likeRepo = likeRepo;
	}
}
