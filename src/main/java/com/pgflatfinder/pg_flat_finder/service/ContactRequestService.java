package com.pgflatfinder.pg_flat_finder.service;

import com.pgflatfinder.pg_flat_finder.entity.ContactRequest;

import java.util.List;

public interface ContactRequestService {

    ContactRequest saveRequest(ContactRequest request);

    List<ContactRequest> getAllRequests();
}