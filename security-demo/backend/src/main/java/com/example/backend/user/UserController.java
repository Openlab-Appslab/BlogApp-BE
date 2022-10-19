package com.example.backend.user;

import com.example.backend.blog.Blog;
import com.example.backend.blog.BlogService;
import com.example.backend.user.dto.BasicInfoUserDTO;
import com.example.backend.user.dto.BlogBasicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private final BlogService blogService;

    @Autowired
    public UserController(UserService userService, BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }

    @GetMapping("/user")
    public BasicInfoUserDTO getUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = userService.getUserByUsername(userDetails.getUsername());

        if(user.isPresent()) {
            return new BasicInfoUserDTO(
                    user.get().getUsername(),
                    user.get().getEmail(),
                    user.get().getAddress(),
                    user.get().getTelephone(),
                    user.get().getFullname()
            );
        }else{
            throw new UsernameNotFoundException("Uzivatel nebol najdeny!");
        }
    }


    @PostMapping(path = "/noAuth/register")
    public User addNewUser (@RequestBody User user) {
        return userService.addUser(user);}

    @GetMapping(path = "/Auth/userBlogs")
    public List<BlogBasicDTO> showBlogsFromUser(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return blogService.getBlogsFromUser(userDetails.getUsername());
    }
}
