package com.example.backend.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) {
        user.setId(0);
        return this.repository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return this.repository.save(user);
    }

}
