package com.examly.springapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;


import com.examly.springapp.model.LikeModel;

public interface likeRepo extends JpaRepository<LikeModel, Integer>{
    
}


