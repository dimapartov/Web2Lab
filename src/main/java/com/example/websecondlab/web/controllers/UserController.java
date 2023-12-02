package com.example.websecondlab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.websecondlab.services.UserService;
import com.example.websecondlab.web.view.user_input.RegisterViewModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String registerUser() {
        return "users-register";
    }

    @ModelAttribute("newUser")
    public RegisterViewModel initUser() {
        return new RegisterViewModel();
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterViewModel newUser, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("newUser", newUser);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newUser", bindingResult);
            return "redirect:/users/register";
        }
        userService.registerUser(newUser);
        return "redirect:/";
    }

    // @DeleteMapping("/delete")
    // public String deleteUser(@RequestParam String username) {
    //     userService.deleteUserByUserName(username);
    //     return "redirect:/register";
    // }

}