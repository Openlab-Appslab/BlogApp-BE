package com.example.backend.user.dto;


public class BasicInfoUserDTO {
    private String username;
    private String email;
    private String address;
    private String telephone;

    public BasicInfoUserDTO() {
    }

    public BasicInfoUserDTO(String username, String email, String address, String telephone) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

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
}
