package com.example.backend.blog;

import com.example.backend.user.User;
import com.example.backend.user.UserRepository;
import com.example.backend.user.dto.CreationOfBlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
                    user.get()
            );

            blogRepository.save(blog);
        }else{
            throw new UsernameNotFoundException("User was not found!");
        }
    }
}
