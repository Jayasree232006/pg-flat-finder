package com.pgflatfinder.pg_flat_finder.repository;

import com.pgflatfinder.pg_flat_finder.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByLocationContainingIgnoreCase(String location);

    List<Property> findByTypeIgnoreCase(String type);
}
