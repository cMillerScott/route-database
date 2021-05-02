package com.arkanstone.routedatabase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("home")
public class HomeController {
    
    @GetMapping
    public String index(Model model) {
        return "index";
    }
}
