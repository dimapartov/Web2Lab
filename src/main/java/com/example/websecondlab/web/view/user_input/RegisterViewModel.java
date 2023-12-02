package com.example.websecondlab.web.view.user_input;



import com.example.websecondlab.util.validation.username.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RegisterViewModel {

    @UniqueUsername
    private String username;
    private String password;


    public RegisterViewModel() {}


    @NotNull
    @NotEmpty(message = "Username cannot be empty")
    @Length(min = 3, message = "Username must contain at least 3 symbols")
    public String getUsername() {
        return username;
    }

    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    @Length(min = 5, message = "Password must contain at least 5 symbols")
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