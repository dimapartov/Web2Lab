package com.example.websecondlab.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/home")
public class HomeController {

    @GetMapping("")
    public String homePage() {
        return "index";
    }
}