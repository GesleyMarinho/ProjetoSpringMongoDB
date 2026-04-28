package com.example.projetomongodbspringboot.config;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.domain.User;
import com.example.projetomongodbspringboot.dto.AuthorDTO;
import com.example.projetomongodbspringboot.dto.ComentDTO;
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

        Post postMaria = new Post(null, sdf.parse("24-04-2026"), "BOM Dia", "Acordei Feliz", maria);
        Post postMaria2 = new Post(null, sdf.parse("27-04-2026"), "Boa Noite", "Bora Dormir", maria);

        ComentDTO c1 = new ComentDTO("Boa Viagem Mano ", sdf.parse("21-03-2018"), new AuthorDTO(alex.getName()));
        ComentDTO c2 = new ComentDTO("Aproveite ", sdf.parse("22-03-2018"), new AuthorDTO(bob.getName()));
        ComentDTO c3 = new ComentDTO("Tenha um Bom Dia ", sdf.parse("23-03-2018"), new AuthorDTO(alex.getName()));

        postMaria.getComments().addAll(Arrays.asList(c1, c2));
        postMaria2.getComments().addAll(Arrays.asList(c3));


        postRepository.saveAll(Arrays.asList(postMaria, postMaria2));
        maria.getPosts().addAll(Arrays.asList(postMaria, postMaria2));
        userRepository.save(maria);
    }
}
