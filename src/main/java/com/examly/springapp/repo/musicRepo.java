package com.examly.springapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.examly.springapp.model.MusicModel;
import java.util.Optional;
import java.util.List;
public interface musicRepo extends JpaRepository<MusicModel, String>{
    Optional<MusicModel> findMusicModelByMusicId(String id);
    
    List<MusicModel> findByMusicNameContainingIgnoreCase(String keyword);
}


