package com.examly.springapp.model;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator; 

@Entity
public class LikeModel implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="uuid1")
    @GenericGenerator(name="uuid1", strategy="uuid2")
    private String Id;
    private Integer noOfLike=0;

    //ManyToMany Mapping (Many users can give like to many songs)
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        joinColumns = { @JoinColumn(name = "userid") }, 
        inverseJoinColumns = { @JoinColumn(name = "likeId") }
    )
    private List<UserModel> likedUser;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((likedUser == null) ? 0 : likedUser.hashCode());
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
        LikeModel other = (LikeModel) obj;
        if (likedUser == null) {
            if (other.likedUser != null)
                return false;
        } else if (!likedUser.equals(other.likedUser))
            return false;
        return true;
    }


    public LikeModel(){
        
    }


    public LikeModel(String id, Integer noOfLike, List<UserModel> userList ) {
        Id = id;
        this.noOfLike = noOfLike;
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
    @JsonIgnore
    public List<UserModel> getUserList() {
        return likedUser;
    }
    public void setUserList(List<UserModel> userList) {
        this.likedUser = userList;
    }
}