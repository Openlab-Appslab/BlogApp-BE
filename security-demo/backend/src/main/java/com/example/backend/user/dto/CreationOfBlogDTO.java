package com.example.backend.user.dto;


public class CreationOfBlogDTO {
    private String name;
    private String content;
    private String author;
    private String category;
    private String date;
    private String title;
    private int likes;


    public CreationOfBlogDTO( String name, String content, String author, String category, String date, String title, int likes) {
        this.name = name;
        this.content = content;
        this.author = author;
        this.category = category;
        this.date = date;
        this.title = title;
        this.likes = likes;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }
}
