package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PropertyService propertyService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "index";
    }
}