package com.example.backend.user;

import com.example.backend.user.exception.UserWasNotFound;
import jdk.internal.org.jline.reader.UserInterruptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public Optional<User> getUserByUsername(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return this.repository.save(user);
    }

    @Override
    @Transactional
    public void editUser(User userFromFE) {
       User user = repository.findByEmail(userFromFE.getEmail())
               .orElseThrow(()->new UserWasNotFound("User wasn't found."));

       //Username

        if(userFromFE.getUsername() != null){
            if(userFromFE.getUsername().length() > 0){
                if(!Objects.equals(user.getUsername(), userFromFE.getUsername())){
                  user.setUsername(userFromFE.getUsername());
                }
            }else{
                throw new IllegalStateException("Length of name is too short! Change it");
            }
        }
            else{
            throw new IllegalStateException("Property is null!");
        }

        //Fullname

        if(userFromFE.getFullname() != null){
            if(userFromFE.getFullname().length() > 0){
                if(!Objects.equals(user.getFullname(), userFromFE.getFullname())){
                    user.setFullname(userFromFE.getFullname());
                }
            }else{
                throw new IllegalStateException("Length of name is too short! Change it");
            }
        }
        else{
            throw new IllegalStateException("Property is null!");
        }

        //Address

        if(userFromFE.getAddress() != null){
            if(userFromFE.getAddress().length() > 0){
                if(!Objects.equals(user.getAddress(), userFromFE.getAddress())){
                    user.setAddress(userFromFE.getAddress());
                }
            }else{
                throw new IllegalStateException("Length of address is too short! Change it");
            }
        }
        else{
            throw new IllegalStateException("Property is null!");
        }

        //Email

        if(userFromFE.getEmail() != null){
            if(userFromFE.getEmail().length() > 0){
                if(!Objects.equals(user.getEmail(), userFromFE.getEmail())){
                    user.setEmail(userFromFE.getEmail());
                }
            }else{
                throw new IllegalStateException("Length of email is too short! Change it");
            }
        }
        else{
            throw new IllegalStateException("Property is null!");
        }

        //phone
        if(userFromFE.getTelephone() != null){
            if(userFromFE.getTelephone().length() > 0){
                if(!Objects.equals(user.getTelephone(), userFromFE.getTelephone())){
                    user.setTelephone(userFromFE.getTelephone());
                }
            }else{
                throw new IllegalStateException("Length of name is too short! Change it");
            }
        }
        else{
            throw new IllegalStateException("Property is null!");
        }
    }
}
