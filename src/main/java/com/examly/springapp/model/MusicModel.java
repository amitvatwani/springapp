package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Email;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import java.util.*;
@Entity
public class MusicModel {
    @Id
    @GeneratedValue(generator="uuid1")
    @GenericGenerator(name="uuid1", strategy="uuid2")
    private String musicId;
    private String musicName;   
    private String musicPosterUrl;
    private String musicUrl;
    private String musicAlbum;
    private String musicArtist;
    @ManyToMany(mappedBy = "playlist")
    private List<UserModel> user;
    

    @OneToOne
    private LikeModel like;
    
    

    public MusicModel() {

    }

    public MusicModel(String musicId, String musicName, String musicPosterUrl, String musicUrl, String musicAlbum, String musicArtist, LikeModel like, List<UserModel> user) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.musicPosterUrl = musicPosterUrl;
        this.musicUrl = musicUrl;
        this.musicAlbum = musicAlbum;
        this.musicArtist = musicArtist;
        this.like = like;
        this.user = user;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicPosterUrl() {
        return musicPosterUrl;
    }

    public void setMusicPosterUrl(String musicPosterUrl) {
        this.musicPosterUrl = musicPosterUrl;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(String musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

    public LikeModel getLike() {
        return like;
    }

    public void setLike(LikeModel like) {
        this.like = like;
    }
    public List<UserModel> getUser() {
        return user;
    }

    public void setUser(List<UserModel> user) {
        this.user = user;
    }
}