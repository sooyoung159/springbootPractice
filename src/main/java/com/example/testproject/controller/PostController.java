package com.example.testproject.controller;

import com.example.testproject.entity.Post;
import com.example.testproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @GetMapping("/list")
    public List<Post> postList(@RequestParam("title") String title){
        return postService.postList(title);
    }

    @GetMapping("/{postId}")
    public Post postDetail(@PathVariable String postId) {
        return new Post(UUID.randomUUID(), "title1", "content1", "soo1", LocalDateTime.now());
    }

}
