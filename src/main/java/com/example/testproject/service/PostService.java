package com.example.testproject.service;

import com.example.testproject.entity.Post;
import com.example.testproject.mapper.PostMapper;
import com.example.testproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public List<Post> postList() {
        return postRepository.findAll();

    }
}
