package com.examly.springapp.controller;
import com.examly.springapp.services.UserService;
import com.examly.springapp.services.MusicService;
import com.examly.springapp.services.LikeService;
import com.examly.springapp.repo.userRepo;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.model.LoginModel;
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
    public CommentController(LikeService likeService, MusicService musicService) {
		this.likeService = likeService;
        this.musicService = musicService;
	}    
    @PostMapping("/like/{id}/{musicId}")
    public int addLike(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        MusicModel music = musicService.findMusicModelByMusicId(id);
        music = music.addLike();
    }
}
