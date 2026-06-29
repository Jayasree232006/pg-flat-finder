package com.pgflatfinder.pg_flat_finder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Double rent;

    @Column(nullable = false)
    private Integer rooms;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String ownerName;

    private boolean available = true;
}