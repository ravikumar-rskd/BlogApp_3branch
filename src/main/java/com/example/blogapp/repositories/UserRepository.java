package com.example.blogapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.blogapp.models.User;
// import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends MongoRepository<User, String> {
}