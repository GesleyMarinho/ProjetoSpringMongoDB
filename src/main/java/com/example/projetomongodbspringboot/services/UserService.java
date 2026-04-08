package com.example.projetomongodbspringboot.services;

import com.example.projetomongodbspringboot.domain.User;
import com.example.projetomongodbspringboot.repository.UserRepository;
import com.example.projetomongodbspringboot.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }


    //busca pela chave id do mongoDB
    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public User findByIndex(int pos) {
        List<User> list = findAll();

        if (pos < 0 || pos >= list.size()) {
            throw new ObjectNotFoundException("Index inválido");
        }

        return list.get(pos);
    }




}
