package com.examly.springapp.controller;
import java.util.Arrays;
import java.util.List;

import com.examly.springapp.model.LikeModel;
import com.examly.springapp.model.MusicModel;
import com.examly.springapp.model.UserModel;

import com.examly.springapp.services.MusicService;
import com.examly.springapp.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    
    private final MusicService musicService;
    private final UserService userService;
    public CommentController(MusicService musicService, UserService userService) {
		
        this.musicService = musicService;
        this.userService = userService;
	} 

    //Add a like for a particular song
    @PostMapping("/like/{id}/{musicId}")
    public LikeModel addLike(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        
        //Searching for user and song in db
        UserModel user = userService.findById(id);
        MusicModel music = musicService.findById(musicId);
        LikeModel like = new LikeModel();

        if(music !=null && user !=null){
            
            //Setting the first like for the song
            if(music.getLike() == null){

                like.setNoOfLike(1);
                like.setUserList(Arrays.asList(user));
                
            }
            else{
                like = music.getLike();   
                List<UserModel> uList = like.getUserList();
                
                //If user has already liked the song
                if(uList.contains(user))
                {
                    return null;
                }
                //Incrementing like by 1
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

    //Remove a like from a particular song
    @DeleteMapping("/like/{id}/{musicId}")
    public LikeModel removeLike(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        
        UserModel user = userService.findById(id);
        MusicModel music = musicService.findById(musicId);
        LikeModel like = new LikeModel();
        if(music !=null && user !=null){
            
            //If the song like count is 0
            if(music.getLike() == null){

                return null;
                
            }
            //dercrementing like by 1
            else{
                like = music.getLike();   
                List<UserModel> uList = like.getUserList();
                
                //If user has liked the song then only he can remove the like
                if(uList.contains(user))
                {
                    uList.remove(user);
                    like.setNoOfLike(like.getNoOfLike() - 1);
                    like.setUserList(uList);
                }
                else
                {
                    return null;
                    
                }
            }
            music.setLike(like);
            musicService.updateMusic(music);
        }
        
        return like;
    }


    //Getting like count of a particular song
    @GetMapping("/like/{musicId}")
    public Integer getLikeCount(@PathVariable(value="musicId") String id){
        MusicModel music = musicService.findById(id);
        if(music!=null)
        return music.getLike().getNoOfLike();
        else
        return null;
    }

    @GetMapping("/admin/comment")
    public int[] getAllComment(){
        int arr[] = new int[5];
        return arr;
    }
}
