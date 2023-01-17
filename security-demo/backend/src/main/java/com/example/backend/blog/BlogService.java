package com.example.backend.blog;

import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.CreationOfBlogDTO;

import java.util.List;

public interface BlogService {
    BlogBasicDTO getBlog(Long id);

    List<BlogBasicDTO> getAllBlogs();

    void addNewBlog(CreationOfBlogDTO creationOfBlogDTO, String username);

    List<BlogBasicDTO> getBlogsFromUser (String email);

    void deleteBlog(Long id, String email);

    List<BlogBasicDTO> getAllTechBlogs();

    List<BlogBasicDTO> getAllZdravieBlogs();

    List<BlogBasicDTO> getAllKulturaBlogs();

    List<BlogBasicDTO> getAllPolitikaBlogs();

    List<BlogBasicDTO> getAllPrirodaBlogs();

    List<BlogBasicDTO> getAllSvetadielBlogs();
}
