package com.example.backend.blog;

import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.CreationOfBlogDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class BlogController {
    private final BlogServiceImpl blogService;

    @Autowired
    public BlogController(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/noAuth/blog/{id}")
    public BlogBasicDTO getBlog(@PathVariable("id") Long id) {
//        try {
//            return new ResponseEntity<>(new BlogResponse(this.blogService.getBlog(blogName)), HttpStatus.OK);
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return blogService.getBlog(id);
    }


    @GetMapping(path = "/noAuth/getAllBlogs")
    public List<BlogBasicDTO> getAllBlogs(){
//        UserDetails user = (UserDetails) authentication.getPrincipal();

        return blogService.getAllBlogs();
    }

    @PostMapping(path = "/Auth/addPost")
    public void testPost(Authentication authentication, @RequestParam("image") MultipartFile image,
                         @RequestParam("data") String data) throws IOException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        blogService.addNewBlog(new ObjectMapper().readValue(data, CreationOfBlogDTO.class), userDetails.getUsername(), image);
    }

    @DeleteMapping("/NoAuth/deleteBlog/{id}")
    public void deleteBlog(@PathVariable Long id, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        blogService.deleteBlog(id, userDetails.getUsername());
    }

    @GetMapping("noAuth/getLastThreeBlogs")
    public List<Blog> getLastThreeBlogs() { return blogService.getLastThreeBlogs(); }

    @GetMapping("/noAuth/getTechBlogs")
    public List<BlogBasicDTO> getTechBlogs() { return blogService.getAllTechBlogs(); }

    @GetMapping("/noAuth/getZdravieBlogs")
    public List<BlogBasicDTO> getZdravieBlogs(){
        return blogService.getAllZdravieBlogs();
    }

    @GetMapping("/noAuth/getKulturaBlogs")
    public List<BlogBasicDTO> getKulturaBlogs(){
        return blogService.getAllKulturaBlogs();
    }

    @GetMapping("/noAuth/getPolitikaBlogs")
    public List<BlogBasicDTO> getPolitikaBlogs(){
        return blogService.getAllPolitikaBlogs();
    }

    @GetMapping("/noAuth/getPrirodaBlogs")
    public List<BlogBasicDTO> getPrirodaBlogs(){
        return blogService.getAllPrirodaBlogs();
    }

    @GetMapping("/noAuth/getSvetadielBlogs")
    public List<BlogBasicDTO> getSvetadielBlogs(){
        return blogService.getAllSvetadielBlogs();
    }

    @GetMapping("noAuth/getBlogByCategory/{category}")
    public List<BlogBasicDTO> getBlogByCategory(@PathVariable String category){
        return blogService.getBlogByCategory(category);
    }
}
