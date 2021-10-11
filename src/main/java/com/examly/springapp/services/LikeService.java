package com.examly.springapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.repo.userRepo;
import com.examly.springapp.repo.musicRepo;
import com.examly.springapp.repo.likeRepo;
import java.security.cert.CertPathValidatorException.Reason;
import java.util.*;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.model.MusicModel;
import com.examly.springapp.model.LikeModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@Service
public class LikeService {
    private final likeRepo likeRepo;

    @Autowired
	public LikeService(likeRepo likeRepo) {
		
		this.likeRepo = likeRepo;
	}

	public LikeModel updateLike(LikeModel likeModel){
		return likeRepo.save(likeModel);
	}

	public LikeModel saveLike(LikeModel like) {
		LikeModel liked = likeRepo.save(like);
		return liked;
	}
}
