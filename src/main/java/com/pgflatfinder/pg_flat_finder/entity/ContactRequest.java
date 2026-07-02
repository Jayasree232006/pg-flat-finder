package com.pgflatfinder.pg_flat_finder.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_requests")
@Data
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String studentPhone;

    private String studentEmail;

    @Column(length = 500)
    private String message;

    @Column(nullable = false)
    private Long propertyId;

    private String status = "PENDING";

    private LocalDateTime createdAt = LocalDateTime.now();
}