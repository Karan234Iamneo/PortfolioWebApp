package com.example.portfolio.repository;

import java.util.*;
import com.example.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    @Query("SELECT p FROM Project p ORDER BY p.title ASC")
    List<Project> findAllOrderedByTitle();
}
