package com.example.websecondlab.web.controllers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger LOG = LogManager.getLogger(Controller.class);


    @GetMapping("/")
    public String homePage() {
        LOG.log(Level.INFO, "Show home page");
        return "index";
    }
}