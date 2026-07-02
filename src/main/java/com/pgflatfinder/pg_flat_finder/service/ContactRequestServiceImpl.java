package com.pgflatfinder.pg_flat_finder.service;

import com.pgflatfinder.pg_flat_finder.entity.ContactRequest;
import com.pgflatfinder.pg_flat_finder.repository.ContactRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactRequestServiceImpl implements ContactRequestService {

    private final ContactRequestRepository contactRequestRepository;

    @Override
    public ContactRequest saveRequest(ContactRequest request) {
        return contactRequestRepository.save(request);
    }

    @Override
    public List<ContactRequest> getAllRequests() {
        return contactRequestRepository.findAll();
    }
}