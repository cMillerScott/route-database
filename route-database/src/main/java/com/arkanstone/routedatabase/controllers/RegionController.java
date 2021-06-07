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

//  controls routing for regions views
@Controller
@RequestMapping("regions")
public class RegionController {

    //  inversion of control for area database
    @Autowired
    private AreaRepository areaRepository;

    //  TODO: populate count of areas associated with each Region
    //  displays table of Regions that link to individual Region pages
    @GetMapping
    public String displayAllRegions(Model model) {
        model.addAttribute("title", "REGIONS");
        model.addAttribute("regions", Region.values());
        model.addAttribute("areas", areaRepository.findAll());
//        model.addAttribute("areaCount", areaRepository.count());

        return "regions/index";
    }

    //  TODO: figure logic to display count of areas associated with individual Region
    //  displays view of individual Region
    @GetMapping("view/{region}")
    public String displayViewRegion(Area area, Model model, @PathVariable Region region) {
        model.addAttribute("title", "REGIONS");
        model.addAttribute("regions", Region.values());
        model.addAttribute("areas", areaRepository.findAll());
//        model.addAttribute("areaCount", areaRepository.count());

        return "regions/view";

    }
}
