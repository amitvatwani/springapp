package com.examly.springapp.controller;
import com.examly.springapp.services.UserService;
import com.examly.springapp.services.MusicService;
import com.examly.springapp.services.LikeService;
import com.examly.springapp.repo.userRepo;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.LikeModel;
import com.examly.springapp.model.MusicModel;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class CommentController {
    private final LikeService likeService;
    private final MusicService musicService;
    private final UserService userService;
    public CommentController(LikeService likeService, MusicService musicService, UserService userService) {
		this.likeService = likeService;
        this.musicService = musicService;
        this.userService = userService;
	} 
    @PostMapping("/like/{id}/{musicId}")
    public LikeModel addLike(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        
        UserModel user = userService.findById(id);
        MusicModel music = musicService.findById(musicId);
        LikeModel like = new LikeModel();
        if(music !=null && user !=null){
            
            if(music.getLike() == null){

                like.setNoOfLike(1);
                like.setUserList(Arrays.asList(user));
                
            }
            else{
                like = music.getLike();   
                List<UserModel> uList = like.getUserList();
                
                if(uList.contains(user))
                {
                    return null;
                }
                else
                {
                    like.setNoOfLike(like.getNoOfLike() + 1);
                    uList.add(user);
                    like.setUserList(uList);
                }
            }
            music.setLike(like);
            musicService.updateMusic(music);
        }
        
        return like;
    }
}
