package com.example.projetomongodbspringboot.resources_controller;

import com.example.projetomongodbspringboot.UserDTO.UserDTO;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> usersList = userService.findAll();

        List<UserDTO> userDTOList = usersList.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(userDTOList);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(userDTO);
    }*/

    @GetMapping("/index/{pos}")
    public UserDTO findByIndex(@PathVariable int pos) {
        List<User> list = userService.findAll();
        return new UserDTO(list.get(pos));
    }
}
