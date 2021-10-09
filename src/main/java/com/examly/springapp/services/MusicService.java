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
public class MusicService {
    private final musicRepo musicRepo;

    @Autowired
	public MusicService(musicRepo musicRepo) {
		
		this.musicRepo = musicRepo;
	}

    public MusicModel addMusic(MusicModel music){
        MusicModel newMusic = musicRepo.save(music);
		return newMusic;
    }

    public List<MusicModel> allMusic(){
        List<MusicModel> musicList = musicRepo.findAll();
		return musicList;
    }

    public MusicModel findById(String id){
		MusicModel music = musicRepo.findMusicModelByMusicId(id).orElse(null);
		return music;
	}

    public MusicModel updateMusic(MusicModel musicModel){
		MusicModel music = musicRepo.save(musicModel);
		return music;
	}

	public void deleteMusic(String id){
		musicRepo.deleteById(id);
	}

}
