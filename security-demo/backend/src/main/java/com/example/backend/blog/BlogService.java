package com.example.backend.blog;

import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.CreationOfBlogDTO;

import java.util.List;

public interface BlogService {
    Blog getBlog(String blogName);

    List<BlogBasicDTO> getAllBlogs(String email);

    void addNewBlog(CreationOfBlogDTO creationOfBlogDTO, String username);

    List<BlogBasicDTO> getBlogsFromUser (String email);
}
