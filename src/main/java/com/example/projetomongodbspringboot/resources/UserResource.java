package com.example.projetomongodbspringboot.resources;

import com.example.projetomongodbspringboot.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<User>> findAll() {
        User M = new User("1", "M", "M@gmail.com");
        User A = new User("2", "A", "A@gmail.com");

        List<User> userList = new ArrayList<>(Arrays.asList(M,A));
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable String id) {

        return new ResponseEntity<>("id"+id, HttpStatus.OK);
    }
}
