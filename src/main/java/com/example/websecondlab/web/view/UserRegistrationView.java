package com.example.websecondlab.web.view;

import com.example.websecondlab.services.dtos.RoleDTO;

public class UserRegistrationView {

    private String username;
    private String password;
    private RoleDTO role;

    public UserRegistrationView() {}


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}