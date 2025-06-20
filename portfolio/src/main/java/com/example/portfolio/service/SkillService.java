package com.example.portfolio.service;

import com.example.portfolio.entity.Skill;
import com.example.portfolio.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository repository;

    public List<Skill> getAll() {
        return repository.findAllOrderedByProficiency();
    }

    public Skill addOrUpdate(Skill skill) {
        return repository.save(skill);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
