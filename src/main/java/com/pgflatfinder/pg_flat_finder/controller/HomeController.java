package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.entity.Property;
import org.springframework.web.bind.annotation.PathVariable;
import com.pgflatfinder.pg_flat_finder.repository.PropertyRepository;
import com.pgflatfinder.pg_flat_finder.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PropertyService propertyService;
    private final PropertyRepository propertyRepository;
    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }
    @GetMapping("/home")
    public String homePage(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String type,
            Model model) {

        List<Property> properties;

        if (location != null && !location.isEmpty()) {
            properties = propertyRepository
                    .findByLocationContainingIgnoreCase(location);
            model.addAttribute("searchLocation", location);
        } else if (type != null && !type.isEmpty()) {
            properties = propertyRepository
                    .findByTypeIgnoreCase(type);
        } else {
            properties = propertyService.getAllProperties();
        }

        model.addAttribute("properties", properties);
        return "index";
    }
    @GetMapping("/property/{id}")
    public String propertyDetails(@PathVariable Long id, Model model) {

        Property property = propertyService.getPropertyById(id);

        model.addAttribute("property", property);

        return "property-detail";
    }
}