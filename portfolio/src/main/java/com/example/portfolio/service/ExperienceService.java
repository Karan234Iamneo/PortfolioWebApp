package com.example.portfolio.service;

import com.example.portfolio.entity.Experience;
import com.example.portfolio.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository repository;

    public List<Experience> getAll() {
        return repository.findAllOrderedByDuration();
    }

    public Experience addOrUpdate(Experience experience) {
        return repository.save(experience);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
    
}
