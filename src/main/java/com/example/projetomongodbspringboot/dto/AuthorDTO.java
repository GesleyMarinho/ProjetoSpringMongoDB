package com.example.projetomongodbspringboot.dto;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO( String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
