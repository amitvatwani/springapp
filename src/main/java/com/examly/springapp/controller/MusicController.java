package com.examly.springapp.controller;
import com.examly.springapp.services.UserService;
import com.examly.springapp.services.MusicService;
import com.examly.springapp.repo.userRepo;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.MusicModel;
import java.util.*;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class MusicController {
    private final MusicService musicService;
    public MusicController(MusicService musicService) {
		this.musicService = musicService;
	}

    @PostMapping("/addmusic")
    public MusicModel addNewMusic(@RequestBody MusicModel image){
                MusicModel music = musicService.addMusic(image);
                return music;
    }

    @GetMapping("/admin/music")
    public List<MusicModel> getAllMusic(){
        List<MusicModel> musicList = musicService.allMusic();
        return musicList;
    }

    @GetMapping("/music")
    public List<MusicModel> getAllMovieList(){
        List<MusicModel> musicList = musicService.allMusic();
        return musicList;
    }

    @PutMapping("/admin/music/{id}")
    public MusicModel musicUpdate(@RequestBody MusicModel music, @PathVariable String id){
        music.setMusicId(id);
        MusicModel musicN = musicService.updateMusic(music);
        return musicN;

    }

    @DeleteMapping("/admin/music/{id}")
    public void musicDelete(@PathVariable String id){
        musicService.deleteMusic(id);
    }

}
