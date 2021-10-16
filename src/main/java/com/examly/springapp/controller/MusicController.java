package com.examly.springapp.controller;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.examly.springapp.model.MusicModel;
import com.examly.springapp.services.MusicService;
import com.examly.springapp.dto.GenericResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MusicController {
    private final MusicService musicService;
    public MusicController(MusicService musicService) {
		this.musicService = musicService;
	}

    //Add song to db
    @PostMapping("/addmusic")
    public MusicModel addNewMusic(@RequestBody MusicModel image){
                MusicModel music = musicService.addMusic(image);
                return music;
    }

    //Get all songs for admin
    @GetMapping("/admin/music")
    public GenericResponse<List<MusicModel>> getAllMusic(){
        List<MusicModel> musicList = musicService.allMusic();
        GenericResponse<List<MusicModel>> response = new GenericResponse<>();
        response.setResponse(musicList);
        return response;
    }

    //Get a particular song by id
    @GetMapping("/admin/music/{id}")
    public MusicModel getMusicById(@PathVariable(value="id") String id){
        MusicModel music = musicService.findById(id);
        return music;
    }

    //Get all songs for user
    @GetMapping("/music")
    public List<MusicModel> getAllMovieList(){
        List<MusicModel> musicList = musicService.allMusic();
        return musicList;
    }

    //Update a song by id
    @PutMapping("/admin/music/{id}")
    public MusicModel musicUpdate(@RequestBody MusicModel music, @PathVariable String id){
        music.setMusicId(id);
        MusicModel musicN = musicService.updateMusic(music);
        return musicN;

    }
    //Delete a song by id
    @DeleteMapping("/admin/music/{id}")
    public void musicDelete(@PathVariable String id){
        musicService.deleteMusic(id);
    }

}
