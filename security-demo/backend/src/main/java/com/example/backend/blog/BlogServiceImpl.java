package com.example.backend.blog;

import com.example.backend.user.User;
import com.example.backend.user.UserRepository;
import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.CreationOfBlogDTO;
import com.example.backend.user.exception.UserWasNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Blog getBlog(String blogName) {
        return blogRepository.findById(blogName).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public void addNewBlog(CreationOfBlogDTO creationOfBlogDTO, String username) {
        Optional<User> user = userRepository.findByEmail(username);

        if(user.isPresent()){
            Blog blog = new Blog(
                    creationOfBlogDTO.getName(),
                    creationOfBlogDTO.getContent(),
                    creationOfBlogDTO.getAuthor(),
                    creationOfBlogDTO.getDate(),
                    user.get(),
                    creationOfBlogDTO.getCategory()
            );
            user.get().getListOfBlog().add(blog);
            blogRepository.save(blog);
            userRepository.save(user.get());
        }else{
            throw new UsernameNotFoundException("User was not found!");
        }
    }

    public BlogBasicDTO convertBlogToDTO(Blog blog, String email){
        return new BlogBasicDTO(
                blog.getName(),
                blog.getContent(),
                blog.getAuthor(),
                blog.getDate(),
                blog.getCategory(),
                email
        );
    }

    public List<BlogBasicDTO> getBlogsFromUser(String email){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
            List<BlogBasicDTO> blogBasicDTOList = new ArrayList<>();

            user.get().getListOfBlog().forEach((e) ->{
                blogBasicDTOList.add(convertBlogToDTO(e, user.get().getEmail()));
            });

            return blogBasicDTOList;
        }else {
            throw new UserWasNotFound("User not found");
        }
    }
}
