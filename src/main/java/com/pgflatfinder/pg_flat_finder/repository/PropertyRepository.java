package com.pgflatfinder.pg_flat_finder.repository;

import com.pgflatfinder.pg_flat_finder.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}