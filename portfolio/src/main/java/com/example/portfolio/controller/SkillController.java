package com.example.portfolio.controller;

import com.example.portfolio.entity.Skill;
import com.example.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
@RequiredArgsConstructor
public class SkillController {

    private final SkillService service;

    @GetMapping
    public List<Skill> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return service.addOrUpdate(skill);
    }

    @PutMapping
    public Skill update(@RequestBody Skill skill) {
        return service.addOrUpdate(skill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
