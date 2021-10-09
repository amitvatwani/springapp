package com.examly.springapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.UserModel;
import java.util.Optional;
import java.util.*;
public interface userRepo extends JpaRepository<UserModel, String>{
    Optional<UserModel> findUserModelByEmail(String email);
    Optional<UserModel> findUserModelById(String id);
    Optional<List<UserModel>> findUserModelByActive(Boolean status);
}


