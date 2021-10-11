package com.examly.springapp.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
@Entity
public class UserModel implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    @Email
    public String email;
    private String password;
    private String username;
    private String mobileNumber;
    private Boolean active=false;
    private String role;
    
    @ManyToMany(mappedBy = "likedUser")
    private List<LikeModel> like; 
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "UserMusic", 
        joinColumns = { @JoinColumn(name = "userid") }, 
        inverseJoinColumns = { @JoinColumn(name = "musicId") }
    )
    private Set<MusicModel> playlist;
    
    

    public UserModel(){

    }

    public UserModel(String id, String email, String password, String username, String mobileNumber, Boolean active, String role, List<LikeModel> like, Set<MusicModel> playlist) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.active = active;
        this.role = role;
        this.like = like;
        this.playlist = playlist;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Set<MusicModel> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Set<MusicModel> playlist) {
        this.playlist = playlist;
    }
}