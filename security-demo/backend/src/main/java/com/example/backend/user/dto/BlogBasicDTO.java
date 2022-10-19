package com.example.backend.user.dto;

public class BlogBasicDTO {

    private String name;
    private String content;
    private String author;
    private String date;
    private String category;
    private String email;
    private String title;

    public BlogBasicDTO(String name, String content, String author, String date, String category, String email, String title) {
        this.name = name;
        this.content = content;
        this.author = author;
        this.date = date;
        this.category = category;
        this.email = email;
        this.title = title;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {  return title;   }

    public void setTitle(String title) {    this.title = title; }
}
