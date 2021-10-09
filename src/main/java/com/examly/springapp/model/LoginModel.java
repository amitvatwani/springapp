package com.examly.springapp.model;
import javax.persistence.*;
import javax.validation.constraints.Email;

public class LoginModel {
    @Email
    private String email;
    private String password;
    public LoginModel(){

    }
    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
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
    
}