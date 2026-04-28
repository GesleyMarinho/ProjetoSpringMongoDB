package com.example.projetomongodbspringboot.controller;

import com.example.projetomongodbspringboot.controller.util.URL;
import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.dto.PostDTO;
import com.example.projetomongodbspringboot.mapper.PostMapper;
import com.example.projetomongodbspringboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;
    @Autowired
    private PostMapper mapper;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> list = postService.findAllPosts()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        Post post = postService.findById(id);

        PostDTO dto = mapper.toDTO(post);

        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {


        text = URL.decodeparam(text);
        List<PostDTO> list = postService.findByTitleContaining(text).stream().map(post -> mapper.toDTO(post)).toList();


        return ResponseEntity.ok(list);
    }
}
