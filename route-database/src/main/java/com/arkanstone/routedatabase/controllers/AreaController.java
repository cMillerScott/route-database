package com.arkanstone.routedatabase.controllers;

import com.arkanstone.routedatabase.data.AreaRepository;
import com.arkanstone.routedatabase.models.Area;
import com.arkanstone.routedatabase.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("areas")
public class AreaController {

    @Autowired
    private AreaRepository areaRepository;

    @GetMapping
    public String displayAllAreas(Model model) {
        model.addAttribute("title", "All Areas");
        model.addAttribute("areas", areaRepository.findAll());
        return "areas/index";
    }

    @GetMapping("create")
    public String displayCreateAreaForm(Model model) {
        model.addAttribute("title", "Add Area");
        model.addAttribute(new Area());
        model.addAttribute("regions", Region.values());
        return "areas/create";
    }

    @PostMapping("create")
    public String createArea(@ModelAttribute @Valid Area newArea, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Area");
            model.addAttribute("regions", Region.values());
            return "areas/create";
        }
        areaRepository.save(newArea);
        return "redirect:";
    }

    @GetMapping("remove")
    public String displayRemoveEventForm(Model model) {
        model.addAttribute("title", "Remove Area");
        model.addAttribute("areas", areaRepository.findAll());
        return "areas/remove";
    }

    @PostMapping("remove")
    public String removeArea(@RequestParam(required = false) int[] areaIds) {
        if (areaIds != null) {
            for (int id : areaIds) {
                areaRepository.deleteById(id);

            }
        }
        return "redirect:";
    }

    @GetMapping("view/{areaId}")
    public String displayViewArea(Model model, @PathVariable int areaId) {

        Optional optArea = areaRepository.findById(areaId);;
        if (optArea.isPresent()) {
            Area area = (Area) optArea.get();
            model.addAttribute("area", area);
            return "areas/view";
        } else {
            return "redirect:../";
        }
    }

}
