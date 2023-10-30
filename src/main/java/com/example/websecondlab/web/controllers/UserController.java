package com.example.websecondlab.web.controllers;

import com.example.websecondlab.services.UserService;
import com.example.websecondlab.web.view.user_input.RegisterViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterViewModel newUser) {
        userService.registerUser(newUser);
        return "path to user page";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String username) {
        userService.deleteUserByUserName(username);
        return "redirect:/register";
    }

}