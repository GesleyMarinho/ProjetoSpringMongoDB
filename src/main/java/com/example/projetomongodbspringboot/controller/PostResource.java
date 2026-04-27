package com.example.projetomongodbspringboot.controller;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.dto.AuthorDTO;
import com.example.projetomongodbspringboot.dto.PostDTO;
import com.example.projetomongodbspringboot.mapper.PostMapper;
import com.example.projetomongodbspringboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper mapper;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> list = postRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

}
