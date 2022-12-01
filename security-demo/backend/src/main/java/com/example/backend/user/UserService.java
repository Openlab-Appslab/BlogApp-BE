package com.example.backend.user;

import com.example.backend.user.dto.EditUserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    Optional<User> getUserByUsername(String username);
    User updateUser(User user);

    void editUser(EditUserDTO userFromFE, String email);

    List<User> getAllUser();

    List<User> getAllAdmin();
}