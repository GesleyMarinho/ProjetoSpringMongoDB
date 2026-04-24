package com.example.projetomongodbspringboot.dto;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
}
