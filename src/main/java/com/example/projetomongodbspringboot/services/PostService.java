package com.example.projetomongodbspringboot.services;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.exception.ObjectNotFoundException;
import com.example.projetomongodbspringboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findById(String id) {

        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado para usuário: " + id));
    }


    public List<Post> findByTitleContaining(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> findByAuthorContaining(String author) {
        return postRepository.findByAuthorName(author);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}

