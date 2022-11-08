package com.example.backend;

import com.example.backend.user.User;
import com.example.backend.user.UserRepository;
import com.example.backend.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class DefaultInitialization //implements CommandLineRunner{
{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    public DefaultInitialization(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserService userService, PasswordEncoder passwordEncoder, UserRepository userRepository){
//        return args-> {
//            String encodePassword= passwordEncoder.encode("1234");
//            User user = new User("Miso", encodePassword, "miso@gmail.com", "KNM", "0903456789", "Michal Sladecek");
//
//            userRepository.save(user);
//        };
//    }






}
