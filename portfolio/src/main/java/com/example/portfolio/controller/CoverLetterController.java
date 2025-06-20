package com.example.portfolio.controller;

import com.example.portfolio.entity.CoverLetter;
import com.example.portfolio.service.CoverLetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coverletter")
@CrossOrigin
@RequiredArgsConstructor
public class CoverLetterController {

    private final CoverLetterService service;

    @GetMapping
    public List<CoverLetter> getAll() {
        return service.getAll();
    }

    @PutMapping
    public CoverLetter update(@RequestBody CoverLetter coverLetter) {
        return service.update(coverLetter);
    }
}
