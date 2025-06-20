package com.example.portfolio.service;

import com.example.portfolio.entity.CoverLetter;
import com.example.portfolio.repository.CoverLetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoverLetterService {
    private final CoverLetterRepository repository;

    public List<CoverLetter> getAll() {
        return repository.findAll();
    }

    public CoverLetter update(CoverLetter letter) {
        return repository.save(letter);
    }
}
