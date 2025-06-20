package com.example.portfolio.repository;

import com.example.portfolio.entity.Experience;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    
    @Query("SELECT e FROM Experience e ORDER BY e.duration DESC")
    List<Experience> findAllOrderedByDuration();
}
