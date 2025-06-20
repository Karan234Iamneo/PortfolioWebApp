package com.example.portfolio.service;

import com.example.portfolio.entity.ContactRequest;
import com.example.portfolio.repository.ContactRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactRequestService {
    private final ContactRequestRepository repository;

    public ContactRequest submit(ContactRequest request) {
        return repository.save(request);
    }

    public List<ContactRequest> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
