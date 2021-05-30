package com.arkanstone.routedatabase.controllers;

import com.arkanstone.routedatabase.data.RouteRepository;
import com.arkanstone.routedatabase.models.Region;
import com.arkanstone.routedatabase.models.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("routes")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @GetMapping
    public String displayAllRoutes(Model model) {

        model.addAttribute("routes", routeRepository.findAll());
        return "routes/index";
    }

    @GetMapping("create")
    public String displayCreateRouteForm(Model model) {

        model.addAttribute(new Route());
        return "routes/create";
    }

    @PostMapping("create")
    public String processCreateRouteForm(@ModelAttribute @Valid Route newRoute, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "routes/create";
        }

        routeRepository.save(newRoute);
        return "redirect:";
    }

    @GetMapping("edit/{routeId}")
    public String displayEditOrRemoveRouteForm(Model model, @PathVariable int routeId) {

        Optional<Route> optRoute = routeRepository.findById(routeId);

        if (optRoute.isPresent()) {
            Route route = (Route) optRoute.get();
            model.addAttribute("route", route);
            return "routes/edit";
        } else {
            return "redirect:";
        }
    }

    @PostMapping("edit/{routeId}")
    public String processEditOrRemoveRouteForm(@RequestParam(required = false) Integer delId, Model model, @ModelAttribute @Valid Route newRoute, Errors errors, @PathVariable int routeId) {

        Optional<Route> optRoute = routeRepository.findById(routeId);

        if (delId != null) {
            routeRepository.deleteById(routeId);
            return "redirect:../";
        }

        if (errors.hasErrors()) {
            model.addAttribute("regions", Region.values());
            return "routes/edit";
        }

        if (optRoute.isPresent()) {
            Route route = (Route) optRoute.get();
            route.setName(newRoute.getName());
            route.setDescription(newRoute.getDescription());
            routeRepository.save(route);
            model.addAttribute("route", route);
            return "routes/view";
        } else {
            return "redirect:";
        }
    }


    @GetMapping("remove")
    public String displayRemoveRouteForm(Model model) {

        model.addAttribute("routes", routeRepository.findAll());
        return "routes/remove";

    }

    @PostMapping("remove")
    public String processRemoveRouteForm(@RequestParam(required = false) int[] routeIds) {

        if (routeIds != null) {
            for (int id : routeIds) {
                routeRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("view/{routeId}")
    public String displayViewArea(Model model, @PathVariable int routeId) {

        Optional<Route> optRoute = routeRepository.findById(routeId);

        if (optRoute.isPresent()) {
            Route route = (Route) optRoute.get();
            model.addAttribute("route", route);
            return "routes/view";
        } else {
            return "redirect:../";
        }
    }

}
