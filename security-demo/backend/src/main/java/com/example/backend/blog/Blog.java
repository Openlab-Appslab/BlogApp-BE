package com.example.backend.blog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    private String name;

    @Column(length = 8000)
    private String content;

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
