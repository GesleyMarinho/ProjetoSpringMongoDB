package com.example.projetomongodbspringboot.services;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> findAllPosts()
    {
        return postRepository.findAll();
    }
}
