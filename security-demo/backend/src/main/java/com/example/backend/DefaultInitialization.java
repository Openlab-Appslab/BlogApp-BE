package com.example.backend;

import com.example.backend.blog.Blog;
import com.example.backend.blog.BlogRepository;
import com.example.backend.blog.BlogService;
import com.example.backend.user.User;
import com.example.backend.user.UserRepository;
import com.example.backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DefaultInitialization //implements CommandLineRunner{
{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final BlogService blogService;
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @Autowired
    public DefaultInitialization(UserService userService, PasswordEncoder passwordEncoder, BlogService blogService, BlogRepository blogRepository, UserRepository userRepository) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.blogService = blogService;
        this.blogRepository = blogRepository;
        this. userRepository = userRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, PasswordEncoder passwordEncoder, UserRepository userRepository){
        return args-> {
//
//                User user = new User("1",
//                        "Sladecek",
//                        "1234",
//                        "michal@michal.sk",
//                        "Neslusa",
//                        "327589235",
//                        "Michal Sladecek");
//
//                userService.addUser(user);
//
//                Blog blog = new Blog(
//                        "Blog1",
//                        "KECI KECI KECI",
//                        "jozo",
//                        "12.124.421",
//                        user,
//                        "Michal",
//                        "vedecky"
//                );
//
//                user.getListOfBlog().add(blog);
//                blogRepository.save(blog);
//                userRepository.save(user);
        };
    }
}
