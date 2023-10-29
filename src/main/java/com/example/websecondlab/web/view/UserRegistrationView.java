package com.example.websecondlab.web.view;

import com.example.websecondlab.services.dtos.RoleDTO;

public class UserRegistrationView {

    private String username;
    private String password;


    public UserRegistrationView(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}