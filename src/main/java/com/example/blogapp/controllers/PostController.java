package com.example.blogapp.controllers;

import com.example.blogapp.models.Post;
import com.example.blogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody PostRequest postRequest) {
        return postService.createPost(postRequest.getTitle(), postRequest.getContent(), postRequest.getUserId());
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PutMapping("/{postId}/approve")
    public void approvePost(@PathVariable int postId) {
        postService.approvePost(postId);
    }
}

class PostRequest {
    private String title;
    private String content;
    private int userId;

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}