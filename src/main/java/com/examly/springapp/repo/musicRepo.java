package com.examly.springapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.MusicModel;
import java.util.Optional;
public interface musicRepo extends JpaRepository<MusicModel, String>{
    Optional<MusicModel> findMusicModelByMusicId(String id);
}


