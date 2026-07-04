package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.pgflatfinder.pg_flat_finder.entity.Property;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final PropertyRepository propertyRepository;

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {

        long totalProperties = propertyRepository.count();

        model.addAttribute("totalProperties", totalProperties);

        return "admin-dashboard";
    }
    @GetMapping("/admin/properties/add")
    public String showAddPropertyForm(Model model) {

        model.addAttribute("property", new Property());

        return "admin-add-property";
    }
    @PostMapping("/admin/properties/add")
    public String saveProperty(Property property) {

        propertyRepository.save(property);

        return "redirect:/admin/dashboard";
    }
    @GetMapping("/admin/properties")
    public String manageProperties(Model model) {

        model.addAttribute(
                "properties",
                propertyRepository.findAll()
        );

        return "admin-properties";
    }
    @GetMapping("/admin/properties/edit/{id}")
    public String showEditPropertyForm(@PathVariable Long id, Model model) {

        Property property = propertyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Property not found with id: " + id));

        model.addAttribute("property", property);

        return "admin-edit-property";
    }
    @PostMapping("/admin/properties/edit/{id}")
    public String updateProperty(@PathVariable Long id, Property property) {

        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Property not found with id: " + id));

        existingProperty.setTitle(property.getTitle());
        existingProperty.setType(property.getType());
        existingProperty.setGender(property.getGender());
        existingProperty.setLocation(property.getLocation());
        existingProperty.setAddress(property.getAddress());
        existingProperty.setGoogleMapsLink(property.getGoogleMapsLink());
        existingProperty.setRent(property.getRent());
        existingProperty.setRooms(property.getRooms());
        existingProperty.setDescription(property.getDescription());
        existingProperty.setContactNumber(property.getContactNumber());
        existingProperty.setOwnerName(property.getOwnerName());
        existingProperty.setAvailable(property.isAvailable());

        propertyRepository.save(existingProperty);

        return "redirect:/admin/properties";
    }
    @GetMapping("/admin/properties/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {

        propertyRepository.deleteById(id);

        return "redirect:/admin/properties";
    }
}