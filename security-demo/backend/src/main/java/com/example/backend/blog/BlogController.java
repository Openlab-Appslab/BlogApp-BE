package com.example.backend.blog;

import com.example.backend.security.UserDetailsImpl;
import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.CreationOfBlogDTO;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.persistence.EntityNotFoundException;

@RestController
public class BlogController {
    private final BlogServiceImpl blogService;

    @Autowired
    public BlogController(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogResponse> getBlog(@PathVariable("id") String blogName) {
        try {
            return new ResponseEntity<>(new BlogResponse(this.blogService.getBlog(blogName)), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/getAllBlogs")
    public List<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }


    @PostMapping(path = "/Auth/addPost")
    public void testPost(Authentication authentication, @RequestBody CreationOfBlogDTO creationOfBlogDTO){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        blogService.addNewBlog(creationOfBlogDTO, userDetails.getUsername());
    }

    @GetMapping(path = "/noAuth/test1")
    public String testSecurity1(){
        return "Neprihlaseny";
    }

    @GetMapping(path = "/Auth/test2")
    public String testSecurity2(){
        return "Prihlaseny";
    }
}
