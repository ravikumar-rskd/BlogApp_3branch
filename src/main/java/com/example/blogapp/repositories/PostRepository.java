package com.example.blogapp.repositories;

//import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.blogapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}