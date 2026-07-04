package com.pgflatfinder.pg_flat_finder.service;

import com.pgflatfinder.pg_flat_finder.entity.ContactRequest;
import com.pgflatfinder.pg_flat_finder.repository.ContactRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRequestServiceImpl implements ContactRequestService {

    private final ContactRequestRepository contactRequestRepository;

    // Explicit constructor for dependency injection
    public ContactRequestServiceImpl(
            ContactRequestRepository contactRequestRepository) {

        this.contactRequestRepository = contactRequestRepository;
    }

    @Override
    public ContactRequest saveRequest(ContactRequest request) {
        return contactRequestRepository.save(request);
    }

    @Override
    public List<ContactRequest> getAllRequests() {
        return contactRequestRepository.findAll();
    }
}