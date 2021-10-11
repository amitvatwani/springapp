package com.examly.springapp.controller;
import java.util.Set;

import com.examly.springapp.model.MusicModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.services.MusicService;
import com.examly.springapp.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {
    
    private final UserService userService;
    private final MusicService musicService;
    public PlaylistController(MusicService musicService, UserService userService) {
		this.musicService = musicService;
        this.userService = userService;
	}

    @PostMapping("/addtoplaylist/{id}/{musicId}")
    public void addSongToPlaylist(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        UserModel user = userService.findById(id);
        MusicModel music = musicService.findById(musicId);
        Set<MusicModel> pList = user.getPlaylist();
        pList.add(music);
        user.setPlaylist(pList);
        userService.updateUser(user);
    }

    @DeleteMapping("/removefromplaylist/{id}/{musicId}")
    public void removeSongFromPlaylist(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        UserModel user = userService.findById(id);
        MusicModel music = musicService.findById(musicId);
        Set<MusicModel> pList = user.getPlaylist();
        if(pList.contains(music))
        {
            pList.remove(music);
        }
        user.setPlaylist(pList);
        userService.updateUser(user);
    }
}
