package com.example.portfolio.controller;

import com.example.portfolio.entity.ContactRequest;
import com.example.portfolio.service.ContactRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
@RequiredArgsConstructor
public class ContactRequestController {

    private final ContactRequestService service;

    @PostMapping
    public ContactRequest submit(@RequestBody ContactRequest request) {
        return service.submit(request);
    }

    @GetMapping
    public List<ContactRequest> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
