package com.arkanstone.routedatabase.controllers;

import com.arkanstone.routedatabase.data.AreaRepository;
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

    @Autowired
    private AreaRepository areaRepository;

    @GetMapping
    public String displayAllRoutes(Model model) {
        model.addAttribute("title", "ROUTES");
        model.addAttribute("routes", routeRepository.findAll());
        return "routes/index";
    }

    @GetMapping("create")
    public String displayCreateRouteForm(Model model) {
        model.addAttribute("title", "ROUTES");
        model.addAttribute(new Route());
        model.addAttribute("areas", areaRepository.findAll());
        return "routes/create";
    }

    @PostMapping("create")
    public String processCreateRouteForm(@ModelAttribute @Valid Route newRoute, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "ROUTES");
            model.addAttribute("areas", areaRepository.findAll());
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
            model.addAttribute("title", "ROUTES");
            model.addAttribute("areas", areaRepository.findAll());
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
            model.addAttribute("title", "ROUTES");
            model.addAttribute("areas", areaRepository.findAll());
            return "routes/edit";
        }

        if (optRoute.isPresent()) {
            Route route = (Route) optRoute.get();
            route.setName(newRoute.getName());
            route.setDescription(newRoute.getDescription());
            route.setArea(newRoute.getArea());
            routeRepository.save(route);
            model.addAttribute("route", route);
            return "routes/view";
        } else {
            return "redirect:";
        }
    }

    @GetMapping("view/{routeId}")
    public String displayViewArea(Model model, @PathVariable int routeId) {

        Optional<Route> optRoute = routeRepository.findById(routeId);

        if (optRoute.isPresent()) {
            Route route = (Route) optRoute.get();
            model.addAttribute("title", "ROUTES");
            model.addAttribute("route", route);
            return "routes/view";
        } else {
            return "redirect:../";
        }
    }

}
