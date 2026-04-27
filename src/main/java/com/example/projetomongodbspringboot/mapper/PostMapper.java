package com.example.projetomongodbspringboot.mapper;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.dto.AuthorDTO;

import com.example.projetomongodbspringboot.dto.PostDTO;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostDTO toDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getDate(),
                post.getTitle(),
                post.getBody(),
                new AuthorDTO(post.getAuthor().getName())
        );
    }
}
