package com.example.websecondlab.web.controllers;

import com.example.websecondlab.services.impl.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.websecondlab.web.view.user_input.RegisterViewModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @GetMapping("/login")
    public String loginUser() {
        return "users-login";
    }
    @PostMapping("/login-error")
    public String onFailedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);
        return "redirect:/users/login";
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
        authenticationService.registerUser(newUser);
        return "redirect:/users/login";
    }
}