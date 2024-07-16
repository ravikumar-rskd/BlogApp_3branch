package com.example.blogapp.models;


// import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Entity
// @Table(name = "users")
@Document(collection = "blogusers")
public class User {
    
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String userId;
    private String username;
    private String email;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

   
    
}