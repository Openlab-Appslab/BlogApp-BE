package com.example.backend.user;

import com.example.backend.blog.Blog;
import com.example.backend.blog.BlogService;
import com.example.backend.user.dto.BasicInfoUserDTO;
import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.EditUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import javax.persistence.Basic;
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
                    user.get().getAdmin(),
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

    @PostMapping(path = "/Auth/EditUser")
    public void editUser(@RequestBody EditUserDTO editUserDTO, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        userService.editUser(editUserDTO, userDetails.getUsername());
    }

//    @DeleteMapping("/NoAuth/deleteUser/{id}")
//    public void deleteUser(@PathVariable Long id, Authentication authentication){
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        userService.deleteUser(id, userDetails.getUsername());
//    }

    @GetMapping(path ="/Auth/GetAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(path = "/Auth/GetAllAdmin")
    public List<User> getAllAdmin(){
        return userService.getAllAdmin();
    }

    @DeleteMapping("/NoAuth/deleteUser/{id}")
    public void deleteUserAndAddUsersBlogToAdmin(@PathVariable Long id){
        userService.deleteUserAndAddUsersBlogToAdmin(id);
    }
}
