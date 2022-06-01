package com.example.backend;

import com.example.backend.user.User;
import com.example.backend.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultInitialization implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public DefaultInitialization(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        this.createAndPersistUser("marek", "marek123", "marek@mailos.com");
        this.createAndPersistUser("adko", "adko1234", "adko@mailos.com");
    }

    private void createAndPersistUser(String username, String password, String email) {
        User user = new User(username, password, email);
        this.userService.addUser(user);
    }

}
