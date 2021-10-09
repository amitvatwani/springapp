package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.CascadeType; 

@Entity
public class LikeModel {
    
    @Id
    private String Id;
    private Integer noOfLike;
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserModel> likedUser;
    public LikeModel(){
        
    }
    public LikeModel(String id, Integer noOfLike, List<UserModel> userList ) {
        Id = id;
        this.noOfLike = noOfLike;
        this.likedUser = userList;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public Integer getNoOfLike() {
        return noOfLike;
    }
    public void setNoOfLike(Integer noOfLike) {
        this.noOfLike = noOfLike;
    }
    public List<UserModel> getUserList() {
        return likedUser;
   }
    public void setUserList(List<UserModel> userList) {
        this.likedUser = userList;
    }
}