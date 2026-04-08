package com.example.projetomongodbspringboot.controller;

import com.example.projetomongodbspringboot.dto.UserDTO;
import com.example.projetomongodbspringboot.domain.User;
import com.example.projetomongodbspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> usersList = userService.findAll();

        List<UserDTO> userDTOList = usersList.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping("/{id}")
    //Recebe a requisição do postman para busca da chave pelo chave id
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserDTO(user));
    }

    @GetMapping("/index/{pos}")
    public ResponseEntity<UserDTO> findByIndex(@PathVariable int pos) {
        User user = userService.findByIndex(pos);
        return ResponseEntity.ok(new UserDTO(user));
    }
}
