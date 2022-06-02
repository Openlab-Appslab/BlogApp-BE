package com.example.backend.blog;

import java.util.List;

public interface BlogService {
    Blog getBlog(String blogName);

    List<Blog> getAllBlogs();
}
