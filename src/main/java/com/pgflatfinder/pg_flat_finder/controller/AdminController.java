package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.repository.ContactRequestRepository;
import com.pgflatfinder.pg_flat_finder.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final PropertyRepository propertyRepository;
    private final ContactRequestRepository contactRequestRepository;

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {

        long totalProperties = propertyRepository.count();
        long totalRequests = contactRequestRepository.count();
        long pendingRequests = contactRequestRepository.countByStatus("PENDING");

        model.addAttribute("totalProperties", totalProperties);
        model.addAttribute("totalRequests", totalRequests);
        model.addAttribute("pendingRequests", pendingRequests);

        return "admin-dashboard";
    }
}