package com.pgflatfinder.pg_flat_finder.controller;

import com.pgflatfinder.pg_flat_finder.entity.ContactRequest;
import com.pgflatfinder.pg_flat_finder.service.ContactRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactRequestController {

    private final ContactRequestService contactRequestService;

    @PostMapping("/contact-request")
    public String saveRequest(ContactRequest request) {

        contactRequestService.saveRequest(request);

        return "redirect:/home";
    }
}