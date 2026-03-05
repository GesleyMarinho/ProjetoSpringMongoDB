package com.example.projetomongodbspringboot.resources;

import com.example.projetomongodbspringboot.domain.User;
import com.example.projetomongodbspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<User>> findAll() {
        List<User> usersList = userService.findAll();
        return ResponseEntity.ok().body(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable String id) {

        return new ResponseEntity<>("id"+id, HttpStatus.OK);
    }
}
