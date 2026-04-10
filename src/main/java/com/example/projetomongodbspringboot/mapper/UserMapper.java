package com.example.projetomongodbspringboot.mapper;

import com.example.projetomongodbspringboot.domain.User;
import com.example.projetomongodbspringboot.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(user);
    }
}
