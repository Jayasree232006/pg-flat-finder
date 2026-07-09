package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.entity.Property;
import com.pgflatfinder.pg_flat_finder.repository.PropertyRepository;
import com.pgflatfinder.pg_flat_finder.service.PropertyService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final PropertyService propertyService;
    private final PropertyRepository propertyRepository;

    // Explicit constructor for dependency injection
    public HomeController(
            PropertyService propertyService,
            PropertyRepository propertyRepository) {

        this.propertyService = propertyService;
        this.propertyRepository = propertyRepository;
    }

    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/home")
    public String homePage(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double minRent,
            @RequestParam(required = false) Double maxRent,
            @RequestParam(required = false) String gender,
            Model model) {

        List<Property> properties = propertyService.getAllProperties();

        if (location != null && !location.trim().isEmpty()) {
            String searchLocation = location.trim();

            properties = properties.stream()
                    .filter(property ->
                            property.getLocation() != null &&
                                    property.getLocation()
                                            .toLowerCase()
                                            .contains(searchLocation.toLowerCase()))
                    .toList();
        }

        if (type != null && !type.trim().isEmpty()) {
            String selectedType = type.trim();

            properties = properties.stream()
                    .filter(property ->
                            property.getType() != null &&
                                    property.getType()
                                            .equalsIgnoreCase(selectedType))
                    .toList();
        }

        if (minRent != null) {
            properties = properties.stream()
                    .filter(property ->
                            property.getRent() != null &&
                                    property.getRent() >= minRent)
                    .toList();
        }

        if (maxRent != null) {
            properties = properties.stream()
                    .filter(property ->
                            property.getRent() != null &&
                                    property.getRent() <= maxRent)
                    .toList();
        }

        if (gender != null && !gender.trim().isEmpty()) {
            String selectedGender = gender.trim();

            properties = properties.stream()
                    .filter(property ->
                            property.getGender() != null &&
                                    property.getGender()
                                            .equalsIgnoreCase(selectedGender))
                    .toList();
        }

        model.addAttribute("searchLocation", location);
        model.addAttribute("selectedType", type);
        model.addAttribute("minRent", minRent);
        model.addAttribute("maxRent", maxRent);
        model.addAttribute("selectedGender", gender);
        model.addAttribute("properties", properties);

        return "index";
    }
    @GetMapping("/property/{id}")
    public String propertyDetails(
            @PathVariable Long id,
            Model model) {

        Property property =
                propertyService.getPropertyById(id);

        model.addAttribute("property", property);

        String foodMenu = property.getFoodMenu();

        if (foodMenu != null && !foodMenu.isBlank()) {

            List<String[]> foodMenuRows = foodMenu.lines()
                    .filter(line -> !line.isBlank())
                    .map(line -> {

                        String[] dayAndMenu =
                                line.split(":", 2);

                        String day =
                                dayAndMenu[0].trim();

                        String menu =
                                dayAndMenu.length > 1
                                        ? dayAndMenu[1].trim()
                                        : "";

                        String[] meals =
                                menu.split("\\|", -1);

                        String breakfast =
                                meals.length > 0
                                        ? meals[0].trim()
                                        : "-";

                        String lunch =
                                meals.length > 1
                                        ? meals[1].trim()
                                        : "-";

                        String dinner =
                                meals.length > 2
                                        ? meals[2].trim()
                                        : "-";

                        return new String[]{
                                day,
                                breakfast,
                                lunch,
                                dinner
                        };
                    })
                    .toList();

            model.addAttribute(
                    "foodMenuRows",
                    foodMenuRows
            );
        }

        return "property-detail";
    }
}