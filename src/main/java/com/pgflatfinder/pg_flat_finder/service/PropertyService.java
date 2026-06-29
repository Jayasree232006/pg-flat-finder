package com.pgflatfinder.pg_flat_finder.service;

import com.pgflatfinder.pg_flat_finder.entity.Property;
import java.util.List;

public interface PropertyService {

    Property saveProperty(Property property);

    List<Property> getAllProperties();

    Property getPropertyById(Long id);

    Property updateProperty(Long id, Property property);

    void deleteProperty(Long id);
}