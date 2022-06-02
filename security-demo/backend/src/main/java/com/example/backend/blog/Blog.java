package com.example.backend.blog;

import com.example.backend.user.User;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    private String name;

    @Column(length = 8000)
    private String content;

    @ManyToOne
    private User user;

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
