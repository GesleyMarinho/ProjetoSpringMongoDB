package com.example.projetomongodbspringboot.config;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.domain.User;
import com.example.projetomongodbspringboot.dto.UserDTO;
import com.example.projetomongodbspringboot.repository.PostRepository;
import com.example.projetomongodbspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.SimpleTimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post postMaria = new Post(null,sdf.parse("24-04-2026"), "BOM Dia", "Acordei Feliz",maria);
        postRepository.saveAll(Arrays.asList(postMaria));
    }
}
