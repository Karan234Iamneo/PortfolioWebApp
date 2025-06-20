package com.example.portfolio.repository;

import com.example.portfolio.entity.Skill;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
    @Query("SELECT s FROM Skill s ORDER BY s.proficiency DESC")
    List<Skill> findAllOrderedByProficiency();
}
