package com.arkanstone.routedatabase.controllers;

import com.arkanstone.routedatabase.data.AreaRepository;
import com.arkanstone.routedatabase.data.RouteRepository;
import com.arkanstone.routedatabase.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//  controls routing for home view
@Controller("home")
public class HomeController {

    //  inversion of control for area database
    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private RouteRepository routeRepository;

    //  displays homepage with count of areas in database
    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "HOME");
        model.addAttribute("regionCount", Region.values().length);
        model.addAttribute("areaCount", areaRepository.count());
        model.addAttribute("routeCount", routeRepository.count());
        return "index";
    }
}
