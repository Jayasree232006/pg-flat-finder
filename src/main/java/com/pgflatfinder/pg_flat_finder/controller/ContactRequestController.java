package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.entity.ContactRequest;
import com.pgflatfinder.pg_flat_finder.service.ContactRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactRequestController {

    private final ContactRequestService contactRequestService;

    // Explicit constructor for dependency injection
    public ContactRequestController(
            ContactRequestService contactRequestService) {
        this.contactRequestService = contactRequestService;
    }

    @PostMapping("/contact-request")
    public String saveRequest(ContactRequest request) {

        contactRequestService.saveRequest(request);

        return "redirect:/home";
    }
}