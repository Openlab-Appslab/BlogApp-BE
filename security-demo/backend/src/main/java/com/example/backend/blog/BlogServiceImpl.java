package com.example.backend.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BlogServiceImpl implements BlogService{

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog getBlog(String blogName) {
        return blogRepository.findById(blogName).orElseThrow(EntityNotFoundException::new);
    }
}
