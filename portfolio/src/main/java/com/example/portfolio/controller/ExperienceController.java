package com.example.portfolio.controller;

import com.example.portfolio.entity.Experience;
import com.example.portfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService service;

    @GetMapping
    public List<Experience> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Experience create(@RequestBody Experience experience) {
        return service.addOrUpdate(experience);
    }

    @PutMapping
    public Experience update(@RequestBody Experience experience) {
        return service.addOrUpdate(experience);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

}
