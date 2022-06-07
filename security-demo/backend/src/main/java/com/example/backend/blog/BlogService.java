package com.example.backend.blog;

import com.example.backend.user.dto.CreationOfBlogDTO;

import java.util.List;

public interface BlogService {
    Blog getBlog(String blogName);

    List<Blog> getAllBlogs();

    void addNewBlog(CreationOfBlogDTO creationOfBlogDTO, String username);
}
