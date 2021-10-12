package com.examly.springapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
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
    //ManyToMany Mapping (Many songs can be added in many user's playlist)
    @ManyToMany(mappedBy = "playlist")
    private List<UserModel> user;
    
    //OneToOne Mapping (One music model follow one like model)
    @OneToOne(cascade=CascadeType.ALL)
    private LikeModel like;
    
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MusicModel other = (MusicModel) obj;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    public MusicModel() {

    }

    public MusicModel(String musicId, String musicName, String musicPosterUrl, String musicUrl, String musicAlbum, String musicArtist, LikeModel like) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.musicPosterUrl = musicPosterUrl;
        this.musicUrl = musicUrl;
        this.musicAlbum = musicAlbum;
        this.musicArtist = musicArtist;
        this.like = like;

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

    public void setUser(List<UserModel> user) {
        this.user = user;
    }
}