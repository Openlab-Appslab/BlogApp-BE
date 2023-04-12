package com.example.backend.blog;

import com.example.backend.Image.Image;
import com.example.backend.Image.ImageRepository;
import com.example.backend.Image.ImageUtility;
import com.example.backend.blog.exception.BlogWasNotFound;
import com.example.backend.user.User;
import com.example.backend.user.UserRepository;
import com.example.backend.user.dto.BlogBasicDTO;
import com.example.backend.user.dto.CreationOfBlogDTO;
import com.example.backend.user.exception.UserWasNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
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
    public BlogBasicDTO getBlog(Long id) {
        //Blog blog = blogRepository.findById(blogName).orElseThrow(EntityNotFoundException::new);

//        Optional<Blog> blog = blogRepository.findById(id);

        Optional<Blog> blog = blogRepository.findById(id);
        if(blog.isPresent()){
            return convertBlogToDTO(blog.get());
        }else{
            throw new BlogWasNotFound("Blog wasn't found!");
        }
    }

    @Override
    public List<BlogBasicDTO> getAllBlogs() {
        List<Blog> blogList = new ArrayList<>(blogRepository.findAll());

        List<BlogBasicDTO> blogBasicDTOList = new ArrayList<>();

        blogList.forEach((e) ->{
            blogBasicDTOList.add(convertBlogToDTO(e));
        });

        return blogBasicDTOList;
    }

    public List<BlogBasicDTO> getBlogsFromUser(String email){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
            List<BlogBasicDTO> blogBasicDTOList = new ArrayList<>();

            user.get().getListOfBlog().forEach((e) ->{
                blogBasicDTOList.add(convertBlogToDTO(e));
            });

            return blogBasicDTOList;
        }else {
            throw new UserWasNotFound("User not found");
        }
    }

    @Override
    public void addNewBlog(CreationOfBlogDTO creationOfBlogDTO, String email, MultipartFile image)
            throws IOException {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            Blog blog = new Blog(
                    creationOfBlogDTO.getName(),
                    creationOfBlogDTO.getContent(),
                    creationOfBlogDTO.getAuthor(),
                    //creationOfBlogDTO.getDate(),
                    user.get(),
                    creationOfBlogDTO.getTitle(),
                    creationOfBlogDTO.getCategory(),
                    image.getBytes()
            );
            user.get().getListOfBlog().add(blog);
            blogRepository.save(blog);
            userRepository.save(user.get());

        }else{
            throw new UsernameNotFoundException("User was not found!");
        }
    }

    @Override
    public void deleteBlog(Long id, String email) {
        Optional<Blog> blog = blogRepository.findById(id);
        Optional<User> user = userRepository.findByEmail(email);

        if(blog.isPresent()){
            user.get().getListOfBlog().remove(blog.get());
            blog.get().setUser(null);

            blogRepository.delete(blog.get());
        }else{
            throw new BlogWasNotFound("Blog was not found!");
        }
    }

    @Override
    public List<BlogBasicDTO> getAllTechBlogs() {
        List<BlogBasicDTO> listOfTechBlog = new ArrayList<>();

        for (Blog blog: blogRepository.findAll()) {
            if(blog.getCategory().equals("Tech"))
                listOfTechBlog.add(convertBlogToDTO(blog));
        }
        return listOfTechBlog;
    }

    @Override
    public List<BlogBasicDTO> getAllZdravieBlogs() {
        List<BlogBasicDTO> listOfZdravieBlog = new ArrayList<>();

        for (Blog blog: blogRepository.findAll()) {
            if(blog.getCategory().equals("Zdravie"))
                listOfZdravieBlog.add(convertBlogToDTO(blog));
        }
        return listOfZdravieBlog;
    }

    @Override
    public List<BlogBasicDTO> getAllKulturaBlogs() {
        List<BlogBasicDTO> listOfKulturaBlog = new ArrayList<>();

        for (Blog blog: blogRepository.findAll()) {
            if(blog.getCategory().equals("Kultúra"))
                listOfKulturaBlog.add(convertBlogToDTO(blog));
        }
        return listOfKulturaBlog;
    }

    @Override
    public List<BlogBasicDTO> getAllPolitikaBlogs() {
        List<BlogBasicDTO> listOfPolitikaBlog = new ArrayList<>();

        for (Blog blog: blogRepository.findAll()) {
            if(blog.getCategory().equals("Politika"))
                listOfPolitikaBlog.add(convertBlogToDTO(blog));
        }
        return listOfPolitikaBlog;
    }

    @Override
    public List<BlogBasicDTO> getAllPrirodaBlogs() {
        List<BlogBasicDTO> listOfPrirodaBlog = new ArrayList<>();

        for (Blog blog: blogRepository.findAll()) {
            if(blog.getCategory().equals("Priroda"))
                listOfPrirodaBlog.add(convertBlogToDTO(blog));
        }
        return listOfPrirodaBlog;
    }

    @Override
    public List<BlogBasicDTO> getAllSvetadielBlogs() {
        List<BlogBasicDTO> listOfSvetadielBlog = new ArrayList<>();

        for (Blog blog: blogRepository.findAll()) {
            if(blog.getCategory().equals("Svetadiel"))
                listOfSvetadielBlog.add(convertBlogToDTO(blog));
        }
        return listOfSvetadielBlog;
    }
    @Autowired
    private BlogService blogService;

    @Override
    public List<BlogBasicDTO> getBlogByCategory(String category) {
        List<BlogBasicDTO> listOfBlogByCategory = new ArrayList<>();

        for (Blog blog: blogRepository.findAll()){
            if(blog.getCategory().equalsIgnoreCase(category))
                listOfBlogByCategory.add(convertBlogToDTO(blog));
        }
        return listOfBlogByCategory;
    }

    public BlogBasicDTO convertBlogToDTO(Blog blog){
        return new BlogBasicDTO(
                blog.getId(),
                blog.getName(),
                blog.getContent(),
                blog.getAuthor(),
                blog.getDate().toString(),
                blog.getCategory(),
                blog.getTitle(),
                blog.getImage()
        );
    }



}
