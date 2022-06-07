package com.example.backend.blog;

import com.example.backend.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    private String name;

    @Column(length = 8000)
    private String content;

    @Column(length = 100)
    private String author;

    @Column(length = 50)
    private String date;

    @ManyToOne
    private User user;

    public Blog(String name, String content, String author, String date, User user) {
        this.name = name;
        this.content = content;
        this.author = author;
        this.date = date;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
