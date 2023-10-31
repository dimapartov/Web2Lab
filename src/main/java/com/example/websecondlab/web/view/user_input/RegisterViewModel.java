package com.example.websecondlab.web.view.user_input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class RegisterViewModel {

    private String username;
    private String password;


    public RegisterViewModel(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @NotNull
    @NotEmpty
    @Length(min = 3, message = "Name must contain at least 3 symbols")
    public String getUsername() {
        return username;
    }

    @NotNull
    @NotEmpty
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