package com.example.backend.blog;

import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.CreationOfBlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;

public interface BlogService {
@Autowired
final BlogRepository blogRepository = null;

    public default List<Blog> getLastThreeObjects(){
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC, "createdAt"));
                return blogRepository.findAll(pageRequest).getContent();
    }

    BlogBasicDTO getBlog(Long id);

    List<BlogBasicDTO> getAllBlogs();

    void addNewBlog(CreationOfBlogDTO creationOfBlogDTO, String username, MultipartFile image) throws IOException;

    List<BlogBasicDTO> getBlogsFromUser (String email);

    void deleteBlog(Long id, String email);

    List<BlogBasicDTO> getAllTechBlogs();

    List<BlogBasicDTO> getAllZdravieBlogs();

    List<BlogBasicDTO> getAllKulturaBlogs();

    List<BlogBasicDTO> getAllPolitikaBlogs();

    List<BlogBasicDTO> getAllPrirodaBlogs();

    List<BlogBasicDTO> getAllSvetadielBlogs();

    List<BlogBasicDTO> getBlogByCategory(String category);
}
