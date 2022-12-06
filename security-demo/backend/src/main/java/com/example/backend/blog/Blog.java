package com.example.backend.blog;

import com.example.backend.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Blog {
    @Id

    private String title;

    @Column(length = 80000)
    private String content;

    @Column(length = 100)
    private String author;

    @Column(length = 50)
    private String date;

    @Column
    private String name;

    private String category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Blog(String name, String content, String author, String date, User user, String title, String category) {
        this.title = title;
        this.name = name;
        this.content = content;
        this.author = author;
        this.date = date;
        this.user = user;
        this.category = category;
    }

    public Blog() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {  return title;  }

    public void setTitle(String title) {    this.title = title; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
