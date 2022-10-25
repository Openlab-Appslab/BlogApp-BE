package com.example.backend.user.dto;

public class EditUserDTO {
    private String username;
    private String address;
    private String telephone;
    private String fullname;

    public EditUserDTO() {
    }

    public EditUserDTO(String username, String fullname ,String address, String telephone ) {
        this.username = username;
        this.fullname = fullname;
        this.telephone = telephone;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {  return telephone; }

    public void setTelephone(String telephone) {    this.telephone = telephone; }

    public String getAddress() {    return address; }

    public void setAddress(String address) {    this.address = address; }

    public String getFullname() {   return fullname;    }

    public void setFullname(String fullname) {  this.fullname = fullname;   }
}
