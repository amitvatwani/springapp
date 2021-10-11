package com.examly.springapp.model;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType; 

@Entity
public class LikeModel implements Serializable{
    
    @Id
    @GeneratedValue(generator="uuid1")
    @GenericGenerator(name="uuid1", strategy="uuid2")
    private String Id;
    private Integer noOfLike=0;
    @OneToMany(mappedBy="like")
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