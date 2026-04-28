package com.example.projetomongodbspringboot.dto;

import com.example.projetomongodbspringboot.domain.Post;
import com.example.projetomongodbspringboot.domain.User;

import java.io.Serializable;
import java.util.Date;

public class ComentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date;
    private String comment;
    private AuthorDTO author;

    public ComentDTO() {
    }

    public ComentDTO(String comment, Date date, AuthorDTO author) {
        this.comment = comment;
        this.date = date;
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}

