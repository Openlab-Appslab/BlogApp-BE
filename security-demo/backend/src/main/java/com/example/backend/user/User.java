package com.example.backend.user;

import com.example.backend.blog.Blog;
import com.example.backend.likes.Likes;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="id",
            updatable = false
    )
    private long id;

    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;

    @Column(
            name = "admin",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String admin;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;
    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            name = "address",
            columnDefinition = "TEXT"
    )
    private String address;
    @Column(
            name = "telephone",
            columnDefinition = "TEXT"
    )
    private String telephone;
    @Column(
            name = "fullname",
            columnDefinition = "TEXT"
    )
    private String fullname;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Blog> listOfBlog;

    @OneToMany(mappedBy = "userid")
    private Set<Likes> likedBlogs;

    public User() {
    }

    public User(String admin, String username, String password, String email, String address, String telephone, String fullname) {
        this.admin = admin;
        this.username = username;
        this.password = password;
        this.email = email;
        this.listOfBlog = new HashSet<>();
        this.address = address;
        this.telephone = telephone;
        this.fullname = fullname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdmin() { return admin; }

    public void setAdmin(String admin) { this.admin = admin; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Set<Blog> getListOfBlog() {
        return listOfBlog;
    }

    public void setListOfBlog(HashSet<Blog> listOfBlog) {
        this.listOfBlog = listOfBlog;
    }

    public String getAddress() { return address;}

    public void setAddress(String address) { this.address = address; }

    public String getTelephone() {return telephone;}

    public void setTelephone(String telephone) {this.telephone = telephone;}

    public String getFullname() {   return fullname;    }

    public void setFullname(String fullname) {  this.fullname = fullname;   }
}
