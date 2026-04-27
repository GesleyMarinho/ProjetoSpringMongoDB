package com.example.projetomongodbspringboot.controller;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.dto.PostDTO;
import com.example.projetomongodbspringboot.dto.UserDTO;
import com.example.projetomongodbspringboot.domain.User;
import com.example.projetomongodbspringboot.mapper.PostMapper;
import com.example.projetomongodbspringboot.mapper.UserMapper;
import com.example.projetomongodbspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;




    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> usersList = userService.findAll();
        return ResponseEntity.ok(usersList.stream().map(mapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    //Recebe a requisição do postman para busca da chave pelo chave id
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(mapper.toDTO(user));
    }

    @GetMapping("/index/{pos}")
    public ResponseEntity<UserDTO> findByIndex(@PathVariable int pos) {
        User user = userService.findByIndex(pos);

        return ResponseEntity.ok(mapper.toDTO(user));
    }

    @Autowired
    private UserMapper mapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {

        User obj = mapper.toEntity(objDTO);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {
        User user = mapper.toEntity(objDTO);
        user.setId(id);
        userService.update(user);
        return ResponseEntity.noContent().build();
    }


    @Autowired
    private PostMapper mapperPost;

    @GetMapping(value="/{id}/posts")
    public ResponseEntity<List<PostDTO>> findPosts(@PathVariable String id) {
        User obj = userService.findById(id);
        List<PostDTO> list = obj.getPosts().stream().map(mapperPost::toDTO).toList();

        return ResponseEntity.ok().body(list);
    }
}
