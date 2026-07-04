package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.entity.Property;
import com.pgflatfinder.pg_flat_finder.service.PropertyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    // Explicit constructor for dependency injection
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<Property> saveProperty(
            @RequestBody Property property) {

        return ResponseEntity.ok(
                propertyService.saveProperty(property)
        );
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {

        return ResponseEntity.ok(
                propertyService.getAllProperties()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                propertyService.getPropertyById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(
            @PathVariable Long id,
            @RequestBody Property property) {

        return ResponseEntity.ok(
                propertyService.updateProperty(id, property)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(
            @PathVariable Long id) {

        propertyService.deleteProperty(id);

        return ResponseEntity.noContent().build();
    }
}