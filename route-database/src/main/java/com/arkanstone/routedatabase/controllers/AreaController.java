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
        model.addAttribute("areas", areaRepository.findAll());
        return "areas/index";
    }

    @GetMapping("create")
    public String displayCreateAreaForm(Model model) {
        model.addAttribute(new Area());
        model.addAttribute("regions", Region.values());
        return "areas/create";
    }

    @PostMapping("create")
    public String processCreateAreaForm(@ModelAttribute @Valid Area newArea, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("regions", Region.values());
            return "areas/create";
        }
        areaRepository.save(newArea);
        return "redirect:";
    }

    @GetMapping("edit/{areaId}")
    public String displayEditAreaForm(Model model, @PathVariable int areaId) {
        Optional<Area> optArea = areaRepository.findById(areaId);

        if (optArea.isPresent()) {
            Area area = (Area) optArea.get();
            model.addAttribute("area", area);
            model.addAttribute("regions", Region.values());
            return "areas/edit";
        } else {
            return "redirect:";
        }
    }

    @PostMapping("edit/{areaId}")
    public String updateArea(Model model, @ModelAttribute @Valid Area newArea, Errors errors, @PathVariable int areaId) {
        Optional<Area> optArea = areaRepository.findById(areaId);

        if (errors.hasErrors()) {
            model.addAttribute("regions", Region.values());
            return "areas/edit";
        }

        if (optArea.isPresent()) {
            Area area = (Area) optArea.get();
            area.setName(newArea.getName());
            area.setDescription(newArea.getDescription());
            area.setRegion(newArea.getRegion());
            areaRepository.save(area);
            model.addAttribute("area", area);
            return "areas/view";
        } else {
            return "redirect:";
        }
    }

    @GetMapping("remove")
    public String displayRemoveAreaForm(Model model) {
        model.addAttribute("areas", areaRepository.findAll());
        return "areas/remove";
    }

    @PostMapping("remove")
    public String processRemoveAreaForm(@RequestParam(required = false) int[] areaIds) {
        if (areaIds != null) {
            for (int id : areaIds) {
                areaRepository.deleteById(id);

            }
        }
        return "redirect:";
    }

    @GetMapping("view/{areaId}")
    public String displayViewArea(Model model, @PathVariable int areaId) {

        Optional<Area> optArea = areaRepository.findById(areaId);;
        if (optArea.isPresent()) {
            Area area = (Area) optArea.get();
            model.addAttribute("area", area);
            return "areas/view";
        } else {
            return "redirect:../";
        }
    }

}
