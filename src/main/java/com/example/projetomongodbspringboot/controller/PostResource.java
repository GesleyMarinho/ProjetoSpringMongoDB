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
import java.util.Date;
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

    @GetMapping("/authorsearch")
    public ResponseEntity<List<PostDTO>> findByAuthor(@RequestParam(value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {
        text = URL.decodeparam(text);
        List<PostDTO> list = postService.findByAuthorContaining(text).stream().map(mapper::toDTO).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) throws UnsupportedEncodingException {

        text = URL.decodeparam(text);

        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<PostDTO> list = postService.fullSearch(text, min, max)
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

}
