package com.example.backend.user;

import com.example.backend.blog.Blog;
import com.example.backend.blog.exception.BlogWasNotFound;
import com.example.backend.user.dto.EditUserDTO;
import com.example.backend.user.exception.UserWasNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {
        //user.setId(0);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id, String email) {
        Optional<User> user = repository.findByEmail(email);
        Optional<User> admin = repository.findById(1L);

        if(user.isPresent()){
            for (Blog blog:user.get().getListOfBlog()
                 ) {
                blog.setUser(admin.get());
                admin.get().getListOfBlog().add(blog);
            }
            user.get().setListOfBlog(null);

            repository.delete(user.get());
        }else{
            throw new UserWasNotFound("User was not found!");
        }
    }

    @Override
    public Optional<User> getUserByUsername(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return this.repository.save(user);
    }

    @Override
    @Transactional
    public void editUser(EditUserDTO userFromFE, String email) {
       User user = repository.findByEmail(email)
               .orElseThrow(()->new UserWasNotFound("User wasn't found."));

       //Username

        if(userFromFE.getUsername() != null){}
            else{throw new IllegalStateException("Property is null!");}


        if(userFromFE.getUsername().length() > 0){
        }else{
            throw new IllegalStateException("Length of name is too short! Change it");
        }

        if(Objects.equals(user.getUsername(), userFromFE.getUsername()) == false){
            user.setUsername(userFromFE.getUsername());
        }else{
            System.out.println("Pica");
        }

        //Fullname

        if(userFromFE.getFullname() != null){}
        else{
            throw new IllegalStateException("Property is null!");}

        if(userFromFE.getFullname().length() > 0){}
        else{
                throw new IllegalStateException("Length of name is too short! Change it");}

        if(!Objects.equals(user.getFullname(), userFromFE.getFullname())){
            user.setFullname(userFromFE.getFullname());
        }


        //Address

        if(userFromFE.getAddress() != null){}
        else{
            throw new IllegalStateException("Property is null!");
        }

        if(userFromFE.getAddress().length() > 0){
        }else{
            throw new IllegalStateException("Length of address is too short! Change it");
        }

        if(!Objects.equals(user.getAddress(), userFromFE.getAddress())){
            user.setAddress(userFromFE.getAddress());
        }

        //Email

//        if(userFromFE.getEmail() != null){
//            if(userFromFE.getEmail().length() > 0){
//                if(!Objects.equals(user.getEmail(), userFromFE.getEmail())){
//                    user.setEmail(userFromFE.getEmail());
//                }
//            }else{
//                throw new IllegalStateException("Length of email is too short! Change it");
//            }
//        }
//        else{
//            throw new IllegalStateException("Property is null!");
//        }

        //phone
        if(userFromFE.getTelephone() != null) {
        }
        else{
            throw new IllegalStateException("Property is null!");
        }

        if(userFromFE.getTelephone().length() > 0){
        }else{
            throw new IllegalStateException("Length of name is too short! Change it");
        }

        if(!Objects.equals(user.getTelephone(), userFromFE.getTelephone())){
            user.setTelephone(userFromFE.getTelephone());
        }

    }

    @Override
    public List<User> getAllUser() {
        List<User> listOfUser = new ArrayList<>();

        for (User user: repository.findAll()){
            if(user.getAdmin() == null){
                listOfUser.add(user);
            }
        }
        return listOfUser;
    }

    @Override
    public List<User> getAllAdmin() {
        List<User> listOfAdmin = new ArrayList<>();

        for (User user: repository.findAll()){
            if(user.getAdmin() != null){
                listOfAdmin.add(user);
            }
        }
        return listOfAdmin;
    }

    @Override
    public void deleteUserAndAddUsersBlogToAdmin(Long id) {
        Optional<User> user = repository.findById(id);
        User undefinedUser = new User();

        for (Blog blog : user.get().getListOfBlog()) {
            blog.setUser(undefinedUser);
        }
        
        user.get().setListOfBlog(null);
        repository.delete(user.get());
    }
}
