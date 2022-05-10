package com.example.backend.blog;

public class BlogResponse {
    private final String name;
    private final String content;

    public BlogResponse(Blog blog) {
        this.name = blog.getName();
        this.content = blog.getContent();
    }
}
