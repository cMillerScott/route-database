package com.arkanstone.routedatabase.controllers;

import com.arkanstone.routedatabase.data.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("home")
public class HomeController {

    @Autowired
    private AreaRepository areaRepository;

    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("areaCount", areaRepository.count());
        return "index";
    }
}
