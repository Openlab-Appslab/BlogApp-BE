package com.example.backend.user.dto;


public class BasicInfoUserDTO {
    private String admin;
    private String username;
    private String email;
    private String address;
    private String telephone;
    private String fullname;

    public BasicInfoUserDTO() {
    }

    public BasicInfoUserDTO(String admin, String username, String email, String address, String telephone, String fullname) {
        this.admin = admin;
        this.username = username;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.fullname = fullname;
    }

    public String getAdmin() { return admin; }

    public void setAdmin(String admin) { this.admin = admin; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {  return telephone; }

    public void setTelephone(String telephone) {    this.telephone = telephone; }

    public String getAddress() {    return address; }

    public void setAddress(String address) {    this.address = address; }

    public String getFullname() {   return fullname;    }

    public void setFullname(String fullname) {  this.fullname = fullname;   }
}
