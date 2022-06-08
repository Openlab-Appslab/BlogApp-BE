package com.example.backend.user;

import com.example.backend.blog.Blog;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    Optional<User> getUserByUsername(String username);
    User updateUser(User user);

}