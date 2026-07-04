package com.pgflatfinder.pg_flat_finder.service;

import com.pgflatfinder.pg_flat_finder.entity.Property;
import com.pgflatfinder.pg_flat_finder.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    // Explicit constructor for dependency injection
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Property not found with id: " + id
                        ));
    }

    @Override
    public Property updateProperty(Long id, Property property) {

        Property existing = getPropertyById(id);

        existing.setTitle(property.getTitle());
        existing.setType(property.getType());
        existing.setGender(property.getGender());
        existing.setLocation(property.getLocation());
        existing.setAddress(property.getAddress());
        existing.setGoogleMapsLink(property.getGoogleMapsLink());
        existing.setRent(property.getRent());
        existing.setRooms(property.getRooms());
        existing.setDescription(property.getDescription());
        existing.setContactNumber(property.getContactNumber());
        existing.setOwnerName(property.getOwnerName());
        existing.setAvailable(property.isAvailable());

        return propertyRepository.save(existing);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}