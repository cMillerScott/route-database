package com.arkanstone.routedatabase.controllers;

import com.arkanstone.routedatabase.data.AreaRepository;
import com.arkanstone.routedatabase.models.Area;
import com.arkanstone.routedatabase.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("regions")
public class RegionController {

    @Autowired
    private AreaRepository areaRepository;

    @GetMapping
    public String displayAllRegions(Model model) {
        model.addAttribute("area", areaRepository.findAll());
        model.addAttribute("regions", Region.values());
        return "regions/index";
    }

//    @GetMapping("view/{areaRegion}")
//    public String displayViewRegion(Model model, @PathVariable String areaRegion) {
//
//    }

}
