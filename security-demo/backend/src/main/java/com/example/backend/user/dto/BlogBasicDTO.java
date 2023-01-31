package com.example.backend.user.dto;

public class BlogBasicDTO {

    private Long id;
    private String name;
    private String content;
    private String author;
    private String date;
    private String category;
    private String title;
    private byte[] image;

    public BlogBasicDTO(Long id, String name, String content, String author, String date, String category, String title, byte[] image) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.date = date;
        this.category = category;
        this.title = title;
        this.image = image;

    }

    public Long getId() { return id;}

    public void setId(Long id) {this.id = id;}

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

    public String getTitle() {  return title;   }

    public void setTitle(String title) {    this.title = title; }

    public byte[] getImage() {  return image;   }

    public void setImage(byte[] image) {    this.image = image; }
}
