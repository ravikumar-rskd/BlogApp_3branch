package com.example.blogapp.services;

import com.example.blogapp.models.Post;
import com.example.blogapp.models.User;
import com.example.blogapp.repositories.PostRepository;
import com.example.blogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Post createPost(String title, String content, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(user);
        post.setApproved(false);
        
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void approvePost(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setApproved(true);
        postRepository.save(post);
    }
}